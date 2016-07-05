# TextWithImageDrawable
an android drawable object which contains text and image

##使用步骤
* 在app的构建文件build.gradle中的dependencies中加入下面的代码
 ```
 
   compile 'wu.seal:textwithimagedrawable:1.0.1'
 
 ```
 现在还需要在build.gradle文件中加上:
 ```
 
 repositories {
    maven { url "https://dl.bintray.com/wusealking/maven/"}
}
```

* 然后就可以直接在代码中使用就可以了
 
## 使用示例:

```java

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

```
