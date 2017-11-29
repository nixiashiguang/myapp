package l2b.recyclertouchevent;

/**
 * created by link on 2017/10/19 : 36.
 * email : libingyang119@163.com
 */

public class Bean {
    String text;
    int pic;
    public Bean(){}
    public Bean(String text, int pic) {
        this.text = text;
        this.pic = pic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
