package wu.seal.textwithimagedrawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/**
 * 两个drawable组合成的一个drawable
 * drawable one 会优先放在最前面进行绘制(如果两个drawable的相对偏移值为0则效果如同FrameLayout)
 * Created By: Seal.Wu
 * Date: 2016/7/12
 * Time: 14:36
 */
public class BaseCombinedDrawable extends Drawable {

    private Drawable one;
    private Drawable two;

    /**
     * two相对one的相对x轴的距离
     */
    private int relatedX;


    /**
     * two相对One的相对y轴的距离
     */
    private int relatedY;

    private int paddingLeft, paddingRight, paddingTop, paddingBottom;

    public BaseCombinedDrawable(Drawable one, Drawable two) {
        this.one = one;
        this.two = two;
        if (one == null || two == null) {
            throw new IllegalArgumentException("drawable one or two can't be null!");
        }
    }


    /**
     * 设置drawable two 左上角相对于 drawable one左上角 的相对偏移位置
     * 偏移以drawable one 的左上角为起始点
     *
     * @param relatedX x轴的相对偏移
     * @param relatedY y轴的相对偏移值
     */
    public void setRelatedPosition(int relatedX, int relatedY) {
        this.relatedX = relatedX;
        this.relatedY = relatedY;
    }


    /**
     * 设置组合后的新的drawable的四个Padding值
     *
     * @param paddingLeft   左边填充距离
     * @param paddingTop    上边填充距离
     * @param paddingRight  右边填充距离
     * @param paddingBottom 下边填充距离
     */
    public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.paddingRight = paddingRight;
        this.paddingBottom = paddingBottom;
    }

    @Override
    public void draw(Canvas canvas) {
        one.setBounds(0, 0, one.getIntrinsicWidth(), one.getIntrinsicHeight());
        two.setBounds(0, 0, two.getIntrinsicWidth(), two.getIntrinsicHeight());
        canvas.translate(paddingLeft, paddingTop);
        canvas.save();
        canvas.translate(relatedX < 0 ? Math.abs(relatedX) : 0, relatedY < 0 ? Math.abs(relatedY) : 0);
        one.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.translate(relatedX > 0 ? Math.abs(relatedX) : 0, relatedY > 0 ? Math.abs(relatedY) : 0);
        two.draw(canvas);
        canvas.restore();
    }

    @Override
    public int getIntrinsicWidth() {
        int width = paddingLeft + paddingRight;
        width = width + one.getIntrinsicWidth();
        if (relatedX < 0) {
            width += Math.abs(relatedX);
        } else {
            final int del = relatedX + two.getIntrinsicWidth() - one.getIntrinsicWidth();
            width += del > 0 ? del : 0;
        }
        return width;
    }

    @Override
    public int getIntrinsicHeight() {

        int height = paddingTop + paddingBottom;
        height += one.getIntrinsicHeight();
        if (relatedY < 0) {
            height += Math.abs(relatedY);
        } else {
            final int del = relatedY + two.getIntrinsicHeight() - one.getIntrinsicHeight();
            height += del > 0 ? del : 0;
        }

        return height;
    }

    @Override
    public void setAlpha(int alpha) {
        one.setAlpha(alpha);
        two.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        one.setColorFilter(colorFilter);
        two.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return one.getOpacity();
    }
}
