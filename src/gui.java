import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class gui {
    gui() {
        JFrame farme = new JFrame("拯救学委2.0");

        // 设置窗口位于屏幕中间
        int sWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int sHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int winX = (sWidth - 500) / 2;
        int winY = (sHeight - 300) / 2;
        farme.setBounds(winX + 50, winY + 50, 500, 300);
        farme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        farme.setLayout(null);

        int midX = 500 / 2 - 120 / 2;
        int midY = 300 / 2 - 30 / 2;

        JTextField text1 = new JTextField();
        text1.setBounds(midX, midY - 35, 120, 30);
        farme.add(text1);

        JTextField text2 = new JTextField();
        text2.setBounds(midX, midY - 75, 120, 30);
        farme.add(text2);

        JLabel label1 = new JLabel("目标文件夹:");
        label1.setBounds(midX - 80, midY - 35, 70, 30);
        farme.add(label1);

        JLabel label2 = new JLabel("关键字:");
        label2.setBounds(midX - 80, midY - 75, 70, 30);
        farme.add(label2);

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(0, 130, 175, 120);
        scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        farme.getContentPane().add(scrollPane_1);
        JTextArea area = new JTextArea(10, 40);
        area.setBounds(0, 130, 175, 120);
        scrollPane_1.setViewportView(area);

        JButton button = new JButton("开始执行");
        button.setSize(120, 30);
        button.setBounds(midX, midY, button.getWidth(), button.getHeight());
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String str1 = text1.getText();
                String str2 = text2.getText();
                int total = 0;
                File folder = new File(System.getProperty("user.dir"));  // 获取当期路径下的文件和文件夹
                File[] files = folder.listFiles();  // 筛选出文件成数组

                for (int i = 0; i < files.length; i++) {  // 遍历文件通过特定字进行分类  采用renameto  永久重命名移动
                    if (files[i].isFile()) {
                        String name = files[i].getName();
                        if (name.indexOf(str2) != -1) {
                            files[i].renameTo(new File(System.getProperty("user.dir") + "/" + str1 + "/" + files[i].getName()));
                            area.append(name + "\n");
                            total++;
                        }
                    }
                }
                area.append("成功移动文件： " + total + " 个");
            }
        });
        farme.add(button);

        farme.setVisible(true);
    }

    public static void main(String[] args) {
        new gui();
    }
}
