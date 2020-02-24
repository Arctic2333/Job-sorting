import java.io.*;

public class autoClassification {
    public static void main(String[] args) throws IOException {
        File folder = new File(System.getProperty("user.dir"));
        File[] files = folder.listFiles();

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                String name = files[i].getName();
                if (name.indexOf("组") != -1) {
                    System.out.println(name);
                    files[i].renameTo(new File(System.getProperty("user.dir") + "/" + "组成原理" + "/" + files[i].getName()));
                }
                if (name.indexOf("系") != -1) {
                    System.out.println(name);
                    files[i].renameTo(new File(System.getProperty("user.dir") + "/" + "系统结构" + "/" + files[i].getName()));
                }
            }
        }

    }
}
