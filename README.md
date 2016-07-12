# TextWithImageDrawable
An android drawable object which contains text and image

可以同时包含文字和图像的Drawable,也可以单独只包含文字或是图像

##使用步骤
* 在app的构建文件build.gradle中的dependencies中加入下面的代码

 ```groove
 
   compile 'wu.seal:textwithimagedrawable:1.0.3'
 
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
        /**
         *  图像资源显示在文字左边的显示效果
         */
        left = (ImageView) findViewById(R.id.iv_left);
        /**
         *  图像资源显示在文字右边的显示效果
         */
        right = (ImageView) findViewById(R.id.iv_right);
        /**
         *  图像资源显示在文字上边的显示效果
         */
        top = (ImageView) findViewById(R.id.iv_top);
        /**
         *  图像资源显示在文字下边的显示效果
         */
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

# BaseCombinedDrawable
An android drawable object which contains two drawables
一个组个drawable,能对两个drawable进行拼凑组合成一个新的drawable,两个drawable的位置可以灵活组合,基本能满足所有的drawable的定制,各种图文混排,你懂的

##Api介绍

```java

     /**
     * 设置drawable two 左上角相对于 drawable one左上角 的相对偏移位置
     * 偏移以drawable one 的左上角为起始点
     * drawable one 会优先放在最前面进行绘制(如果两个drawable的相对偏移值为0则效果如同FrameLayout)
     *
     * @param relatedX x轴的相对偏移
     * @param relatedY y轴的相对偏移值
     */
     public void setRelatedPosition(int relatedX, int relatedY)
    
    
    /**
     * 设置组合后的新的drawable的四个Padding值
     *
     * @param paddingLeft   左边填充距离
     * @param paddingTop    上边填充距离
     * @param paddingRight  右边填充距离
     * @param paddingBottom 下边填充距离
     */
     public void setPadding(int paddingLeft, int paddingTop, int paddingRight, int paddingBottom)
    
```

##代码示例

```java

        BaseCombinedDrawable baseCombinedDrawable = new BaseCombinedDrawable(drawableLeft, drawableRight);
        baseCombinedDrawable.setRelatedPosition(drawableLeft.getIntrinsicWidth() + drawablePadding, 0);
        combine.setImageDrawable(baseCombinedDrawable);

```


##效果图:
<img src="https://github.com/wuseal/TextWithImageDrawable/blob/master/demo.png?raw=true" alt="alt text" >
 
