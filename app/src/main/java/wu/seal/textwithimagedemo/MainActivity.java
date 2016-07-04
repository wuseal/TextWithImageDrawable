package wu.seal.textwithimagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.ImageView;

import wu.seal.textwithimagedrawable.TextWithImageDrawable;


public class MainActivity extends AppCompatActivity {

    ImageView left, right, top, bottom;

    String mText = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = (ImageView) findViewById(R.id.iv_left);
        right = (ImageView) findViewById(R.id.iv_right);
        top = (ImageView) findViewById(R.id.iv_top);
        bottom = (ImageView) findViewById(R.id.iv_bottom);

        /**
         * 图像和文字之间的距离
         */
        final int drawablePadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());

        TextWithImageDrawable drawableLeft = new TextWithImageDrawable(this);
        initDrawable(drawablePadding, drawableLeft, mText, TextWithImageDrawable.Position.LEFT);
        left.setImageDrawable(drawableLeft);

        TextWithImageDrawable drawableRight = new TextWithImageDrawable(this);
        initDrawable(drawablePadding, drawableRight, mText, TextWithImageDrawable.Position.RIGHT);
        right.setImageDrawable(drawableRight);

        TextWithImageDrawable drawableTop = new TextWithImageDrawable(this);
        initDrawable(drawablePadding, drawableTop, mText, TextWithImageDrawable.Position.TOP);
        top.setImageDrawable(drawableTop);

        TextWithImageDrawable drawableBottom = new TextWithImageDrawable(this);
        initDrawable(drawablePadding, drawableBottom, mText, TextWithImageDrawable.Position.BOTTOM);
        bottom.setImageDrawable(drawableBottom);




    }

    private void initDrawable(int drawablePadding, TextWithImageDrawable drawable, String mText, TextWithImageDrawable.Position position) {
        drawable.setText(mText);
        drawable.setImagePosition(position);
        drawable.setImagePadding(drawablePadding);
        drawable.setImageRes(R.mipmap.ic_launcher);
    }

}
