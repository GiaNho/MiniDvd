import java.text.ParseException;
import java.util.Scanner;
/**
 * ClassName: Start

 * @Description:程序入口
 * @author
 * @date
 */
public class Start {
    static DVDMgr mgr = new DVDMgr();
    public static void main(String[] args) throws ParseException {
        mgr.initial();
        startMenu();
    }

    public static void startMenu() throws ParseException {
        do {
            System.out.println("欢迎使用迷你DVD管理器");
            System.out.println("- - - - - - - - - - - - - - ");
            System.out.println("0.借出排行榜");
            System.out.println("1.新增DVD");
            System.out.println("2.查看DVD");
            System.out.println("3.删除DVD");
            System.out.println("4.借出DVD");
            System.out.println("5.归还DVD");
            System.out.println("6.退   出");
            System.out.println("- - - - - - - - - - - - - - ");
            System.out.print("请选择：");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 0:
                    System.out.println("---> 排行榜");
                    mgr.top();
                    break;
                case 1:
                    System.out.println("---> 新增DVD");
                    mgr.add();
                    break;
                case 2:
                    System.out.println("---> 查看DVD");
                    mgr.search();
                    break;
                case 3:
                    System.out.println("---> 删除DVD");
                    mgr.delete();
                    break;
                case 4:
                    System.out.println("---> 借出DVD");
                    mgr.borrow();
                    break;
                case 5:
                    System.out.println("---> 归还DVD");
                    mgr.returnDVD();
                    break;

                case 6:
                    System.out.println("\n\n谢谢使用！");
                    return;
                default:
                    System.out.println("您的输入有误，请核对后重新输入：");
                    break;
            }
            returnMain();
        } while (true);
    }

    public static void returnMain() {
        boolean isreturn = true;
        System.out.println("* * * * * * * * * *");
        System.out.print("输入0返回：");
        do {
            Scanner input = new Scanner(System.in);
            if (input.nextInt() == 0) {
                isreturn = false;
            } else {
                System.out.println("您的输入有误，请核对后重新输入：");
            }
        } while (isreturn);

    }

}

