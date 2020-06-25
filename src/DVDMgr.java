
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * ClassName: DVDMgr
 *
 * @Description: DVD管理类
 * @author
 * @date 2019年6月13日
 */
public class DVDMgr {

    DVD[] dvd = new DVD[50];
    DVD[] dvdTop = new DVD[50];

    public void initial() {

        dvd[0] = new DVD("罗马假日", 0, "2010-7-1", 9);
        dvd[1] = new DVD("风声鹤唳", 1, "", 1);
        dvd[2] = new DVD("浪漫满屋", 1, "", 4);
        dvd[3] = new DVD("红与黑", 0, "2018-12-31", 11);
        dvd[4] = new DVD("老友记", 1, "", 12);
        dvd[5] = new DVD("三国演义", 0, "2018-5-5", 7);
        dvd[6] = new DVD("权力的游戏", 1, "", 2);
        dvd[7] = new DVD("生活大爆炸", 0, "2019-6-1", 6);
        dvd[8] = new DVD("西游记", 1, "", 3);
    }

    public void search() {
        System.out.println("序号\t状态\t名称\t\t借出日期");
        int i = 0;
        String status;
        while (dvd[i] != null && i < dvd.length) {
            if (dvd[i].state == 0) {
                status = "已借出";
            } else {
                status = "可借";
            }
            System.out.println((i + 1) + "\t" + status + "\t" + dvd[i].name + "\t" + dvd[i].date);
            i = i + 1;
        }

    }

    public void add() {
        System.out.print("请输入DVD名称：");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < dvd.length; i++) {
            if (dvd[i] == null && i < dvd.length) {
                dvd[i] = new DVD(input.next(), 1, "", 0);
                System.out.println("新增《" + dvd[i].name + "》成功");
                break;
            }
        }
    }

    public void delete() {
        System.out.print("请输入要删除的DVD名称：");
        Scanner input = new Scanner(System.in);
        String deleteName = input.next();
        int i = 0;
        while (dvd[i] != null && i < dvd.length) {
            if (deleteName.equals(dvd[i].name)) {
                if (dvd[i].state == 0) {
                    System.out.println("《" + dvd[i].name + "》为借出状态，不能删除！");
                    return;
                } else {
                    System.out.println("《" + dvd[i].name + "》删除成功");
                    // 删除后将之后的前移。
                    int lastindex = 0;
                    for (int j = i + 1; dvd[j] != null && j < dvd.length; j++) {
                        dvd[j - 1] = dvd[j];
                        lastindex = j;
                    }
                    if (i > lastindex) {// 如果i>lastindex，表明没有进行上面的for循环，也就是说所删除的就是最后一个。
                        dvd[i] = null;
                    } else {// 否则删除的不是最后一个，进行了for循环（后面元素前移操作），将最后一个元素置空
                        dvd[lastindex] = null;
                    }
                    break;
                }
            }
            i++;
        }
        System.out.println("不存在要删除的DVD名称，请确认后重新输入！");
    }

    public void borrow() throws ParseException {
        System.out.print("请输入DVD名称：");
        Scanner input = new Scanner(System.in);
        String borrowName = input.next();
        System.out.print("请输入借出日期（年-月-日）：");
        String borrowDate = input.next();
        int i = 0;
        while (dvd[i] != null && i < dvd.length) {
            if (dvd[i].name.equals(borrowName)) {
                if (dvd[i].state == 1) {
                    System.out.println("借出《" + dvd[i].name + "》成功！");
                    dvd[i].state = 0;
                    dvd[i].date = borrowDate;
                    dvd[i].count++;
                } else {
                    System.out.print("《" + dvd[i].name + "》已被借出。");
                }
                return;
            }
            i++;
        }
        System.out.println("《" + borrowName + "》不存在。");

    }

    public void returnDVD() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print("请输入DVD名称：");
        Scanner input = new Scanner(System.in);
        String returnName = input.next();
        System.out.print("请输入归还日期（年-月-日）：");
        String returnDate = input.next();
        int i = 0;
        while (dvd[i] != null && i < dvd.length) {
            if (dvd[i].name.equals(returnName)) {
                System.out.println("归还《" + dvd[i].name + "》成功！");
                System.out.println("借出日期为：" + dvd[i].date);
                System.out.println("归还日期为：" + returnDate);
                Date d1 = sdf.parse(dvd[i].date);
                Date d2 = sdf.parse(returnDate);
                double charge = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);// getTime获取日期的毫秒数
                System.out.println("应付租金（元）：" + charge);
                dvd[i].state = 1;
                dvd[i].date = "";
                return;
            }
            i++;
        }
        System.out.println("输入归还的DVD名称不存在，请核对后重新输入：");
    }

    public void top() {
        System.out.println("* * * * * * * * * *");
        System.out.println("次数\t名称");
        int i = 0;
        while (dvd[i] != null && i < dvdTop.length) {
            dvdTop[i] = dvd[i];
            i++;
        }

        for (int j = 0; dvdTop[j] != null && j < dvdTop.length; j++) {
            for (int k = 1; dvdTop[k] != null && k < dvdTop.length; k++) {
                if (dvdTop[k - 1].count < dvdTop[k].count) {
                    DVD temp = dvdTop[k];
                    dvdTop[k] = dvdTop[k - 1];
                    dvdTop[k - 1] = temp;
                }
            }
        }
        for (int f = 0; dvdTop[f] != null && f < dvdTop.length; f++) {
            System.out.println(dvdTop[f].count + "\t《" + dvdTop[f].name + "》");
        }

    }

}


