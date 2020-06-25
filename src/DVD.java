
/**
 *
 * ClassName: DVD
 *
 * @Description: DVD类
 * @author
 * @date
 */

public class DVD {

    protected String name;
    protected int state;
    protected String date;
    protected int count=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



    public DVD(String name, int state, String date, int count) {
        super();
        this.name = name;
        this.state = state;
        this.date = date;
        this.count = count;
    }

    public DVD() {

    }

}
