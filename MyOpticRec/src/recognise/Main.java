package recognise;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    static Map<String, String> mappair = new HashMap<>();
    static String veight;
    static int w, h, offT, offL;
    static List<String> firstcard = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//Предварительно сняты образы карт в виде строк и помещены в map: mappair
// Читаем колоду в map: mappair
        File etalon = new File("D:\\MyOpticRec\\imgs22\\");
        for (File et : Objects.requireNonNull(etalon.listFiles())) {
            BufferedReader reader = new BufferedReader(new FileReader(et.getCanonicalPath()));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = "";
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            String bufread = stringBuilder.toString();
            veight = et.getName();
            String[] arrOfStr = veight.split("\\.");
            mappair.put(arrOfStr[0], bufread);
        }
//Берем изображение карт поочередо из папки improv ,
//w,h,offT,offL ширина символа , высота , отступ сверху , отступ слева
//Проходим три раза с разными координатами, соответствующими расположению символа на карте
        File dir = new File("D:\\MyOpticRec\\improv\\");
        for (File item : Objects.requireNonNull(dir.listFiles())) {
            for (int i = 1; i <= 3; i++) {
                if (i == 1) {
                    w = 22;h = 22;offT = -592;offL = -148;
                }

                if (i == 2) {
                    w = 22;h = 22;offT = -592;offL = -220;
                }
                if (i == 3) {
                    w = 22;h = 22;offT = -592;offL = -291;
                }

                int width = w, height = h, offsetTop = offT, offsetLeft = offL;
//Берем карту
                BufferedImage image = null;
                try {
                    image = ImageIO.read(new File(item.getCanonicalPath()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
//Превращаем в растровое изображение
                BufferedImage symbol = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
                Graphics2D g = symbol.createGraphics();
                g.drawImage(image, offsetLeft, offsetTop, null);

                short whiteBg = -1;
                StringBuilder binaryString = new StringBuilder();
//Смотрим Альфа канал (-1 значит непрозрачен т.е. белый (соответствует пробелу ))
                for (short y = 1; y < height; y++)
                    for (short x = 1; x < width; x++) {
                        int rgb = symbol.getRGB(x, y);
                        binaryString.append(rgb == whiteBg ? " " : "*");
                    }
// В итоге получаем строку из пробелов и знаков *
                String s = binaryString.toString();
// Эмпирически подобранное расстояние
                int min = 43;
                String findSymbol = "";
                int recon = 0;
//  В цикле сравниваем колоду и символ
                for (Map.Entry<String, String> entry : mappair.entrySet()) {
                    int levenshtein = levenshtein(s, entry.getValue());
// Берем максимально похожий
                    if (levenshtein < min) {
                        recon = 1;
                        findSymbol = entry.getKey();
                        firstcard.add(findSymbol);
                    }
                }
// Если не распознан ставим Empty
                if (recon == 0) {
                    firstcard.add("Empty++");
                }
            }
        }
// Разбивка по тройкам (на столе три карты )
        for (int i = 0, j = 1; i < firstcard.toArray().length; i++, j++) {
            if (j % 3 != 0)
                System.out.print(firstcard.toArray()[i]);
            else
                System.out.print(firstcard.toArray()[i] + " ");
        }
    }
// Алгоритм Левенштейна  по нахождению кратчайшего расстояния вхождения одной строки в другую
    public static int levenshtein(String targetStr, String sourceStr) {
        int m = targetStr.length(), n = sourceStr.length();
        int[][] delta = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            delta[i][0] = i;
        for (int j = 1; j <= n; j++)
            delta[0][j] = j;
        for (int j = 1; j <= n; j++)
            for (int i = 1; i <= m; i++) {
                if (targetStr.charAt(i - 1) == sourceStr.charAt(j - 1))
                    delta[i][j] = delta[i - 1][j - 1];
                else
                    delta[i][j] = Math.min(delta[i - 1][j] + 1,
                            Math.min(delta[i][j - 1] + 1, delta[i - 1][j - 1] + 1));
            }
        return delta[m][n];
    }
}
