# TextWithImageDrawable
an android drawable object which contains text and image

##使用步骤
* 在app的构建文件build.gradle中的dependencies中加入下面的代码
 ```groove
 
   compile 'wu.seal:textwithimagedrawable:1.0.2'
 
 ```

* 然后就可以直接在代码中使用就可以了

## Api的简单介绍

```java

            /**
             * 实例化一个同时包含文字和图片的drawable
             */
            TextWithImageDrawable textWithImageDrawable = new TextWithImageDrawable(thisActivity);
            /**
             * 设置drawable里的文字
             */
            textWithImageDrawable.setText(text);
            /**
             * 设置drawable里的图像资源
             */
            textWithImageDrawable.setImageRes(leftMenuIconResId);
             /**
             * 设置drawable里的图像资源
             */
            textWithImageDrawable.setImageBitmap(mBitmap);
             /**
             * 设置drawable里的drawable
             */
            textWithImageDrawable.setDrawable(mDrawable);
            /**
             * 设置drawable中文字的大小,注意此处的单位是sp
             */
            textWithImageDrawable.setTextSize(16);
            /**
             * 设置文字的颜色
             */
            textWithImageDrawable.setTextColor(getResources().getColor(R.color.text_color_white));
            /**
             * 设置文字和图像之间的间隔,单位是px
             */
            textWithImageDrawable.setImagePadding(DensityUtils.dip2px(5));
            /**
             * 设置此drawable的左边填充大小,单位px
             */
            textWithImageDrawable.setPaddingLeft(DensityUtils.dip2px(8));
            /**
             * 设置此drawable上方填充大小,单位px
             */
            textWithImageDrawable.setPaddingTop(DensityUtils.dip2px(6));
            /**
             * 设置此drawable的最大文字限制长度
             */
            textWithImageDrawable.setMaxTextLength(3);
            /**
             * 设置图像和文字的相对位置,此处设置的是图像在文字右边显示
             */
            textWithImageDrawable.setImagePosition(TextWithImageDrawable.Position.RIGHT);

```
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

##效果图:
<img src="https://github.com/wuseal/TextWithImageDrawable/blob/master/demo.png?raw=true" alt="alt text" >
 
