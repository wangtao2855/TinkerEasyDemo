package com.example.wangtao.animationdemo.MyView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.wangtao.animationdemo.R;
import com.example.wangtao.animationdemo.utils.ScreenUtils;

import java.io.InputStream;

/**
 * Created by wangtao on 2018/5/15.
 */

@SuppressLint("ViewConstructor")
public class PageFactory extends View {

    private Context context;
    private RectF rectf;
    private RectF rectf2;
    private RectF rectf3;
    private Paint paintBgSel;
    private Paint paintBg;
    private String selNum = "0";
    private Bitmap bufferBitmap;
    private Canvas bufferCanvas;

    public PageFactory(Context context) {
        super(context);
        this.context = context;
    }

    public PageFactory(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public PageFactory(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bufferCanvas = new Canvas();
        bufferBitmap = Bitmap.createBitmap(ScreenUtils.getScreenWidth(),ScreenUtils.getScreenHeight(), Bitmap.Config.ARGB_8888);
        //3. 将缓冲位图设置给缓冲画布
        bufferCanvas.setBitmap(bufferBitmap);
        //5. 用屏幕的画布绘制缓冲位图
        canvas.drawBitmap(bufferBitmap,0,0, null);
        SpannableString spannableString =new SpannableString("怎么保存当页 下一页的逻辑 以及点击事件 然后以及一些文字点击怎么保存当页 下一页的逻辑 以及点击事件 然后以及一些文字点击怎么保存当页 下一页的逻辑 以及点击事件 然后以及一些文字点击怎么保存当页 下一页的逻辑 以及点击事件 然后以及一些文字点击");
        canvas.drawText("ss",0,0,paintBgSel);
        drawReLoadBtn1(canvas);
    }

    public Bitmap decodeBitmapFromRes(Context context, int resourceId) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;

        InputStream in = context.getResources().openRawResource(resourceId);
        return BitmapFactory.decodeStream(in, null, options);
    }

    private void drawText(Canvas canvas, String text, float x, float y, Paint paint, float angle) {
        if (angle != 0) {
            canvas.rotate(angle, x, y);
        }
        canvas.drawText(text, x, y, paint);
        if (angle != 0) {
            canvas.rotate(-angle, x, y);
        }
    }

    private void drawReLoadBtn1(Canvas canvas) {


        int roundheight = 73;//dp

        float left1 = 30;
        float top1 = ScreenUtils.getScreenHeight() / 2;
        float right1 = (ScreenUtils.getScreenWidth() - 30 * 4) / 3;
        float bottom = top1 + ScreenUtils.dpToPx(roundheight);

        paintBgSel = new Paint();
        paintBgSel.setColor(Color.parseColor("#FDEDE4"));

        Paint paintSize = new Paint();
        paintSize.setTextSize(30);
        paintBgSel.setColor(Color.parseColor("#FDEDE4"));
        drawText(canvas, "free", 150, 180, paintSize, 45);

        paintBg = new Paint();
        paintBg.setColor(Color.WHITE);

        rectf = new RectF(left1, top1, right1 + left1, bottom);
        canvas.drawRoundRect(rectf, 10f, 10f, paintBg);
        float left2 = rectf.right + left1;
        rectf2 = new RectF(rectf.right + left1, top1, right1 * 2 + left1 * 2, bottom);
        canvas.drawRoundRect(rectf2, 10f, 10f, paintBg);
        float left3 = rectf2.right + left1;
        rectf3 = new RectF(rectf2.right + left1, top1, right1 * 3 + left1 * 3, bottom);
        canvas.drawRoundRect(rectf3, 10f, 10f, paintBg);


        if (selNum.equals("0")) {
            canvas.drawRoundRect(rectf, 10f, 10f, paintBgSel);
        } else if (selNum.equals("1")) {
            canvas.drawRoundRect(rectf2, 10f, 10f, paintBgSel);
        } else {
            canvas.drawRoundRect(rectf3, 10f, 10f, paintBgSel);
        }
//绘制微信图标
        bufferCanvas.drawBitmap(decodeBitmapFromRes(getContext(), R.mipmap.page_bg), right1 + left1 - 70, top1, null);
        drawText(canvas, "free", right1 + left1 - 30, top1+18, paintSize, 45);

        Paint pTitle = new Paint();
        pTitle.setColor(Color.parseColor("#FF333333"));
        pTitle.setTextSize(28);
        String strTitle = "3000笛笛币";

        canvas.drawText(strTitle, left1 + 40, top1 + 50, pTitle);
        canvas.drawText(strTitle, left2 + 40, top1 + 50, pTitle);
        canvas.drawText(strTitle, left3 + 40, top1 + 50, pTitle);

        Paint pJuan = new Paint();
        pJuan.setColor(Color.parseColor("#F29508"));
        pJuan.setTextSize(22);
        String strJuan = "送500书券";

        canvas.drawText(strJuan, left1 + 40, top1 + 90, pJuan);
        canvas.drawText(strJuan, left2 + 40, top1 + 90, pJuan);
        canvas.drawText(strJuan, left3 + 40, top1 + 90, pJuan);

        Paint pMoney = new Paint();
        pMoney.setColor(Color.parseColor("#A6A6A6"));
        pMoney.setTextSize(22);
        String strMoney = "30元";

        canvas.drawText(strMoney, left1 + 40, bottom - 25, pMoney);
        canvas.drawText(strMoney, left2 + 40, bottom - 25, pMoney);
        canvas.drawText(strMoney, left3 + 40, bottom - 25, pMoney);
        //绘制下面的支付方式
        pMoney.setTextSize(28);
        canvas.drawText("支付方式：", left1 + 60, bottom + 100, pMoney);
        //绘制微信图标
        bufferCanvas.drawBitmap(decodeBitmapFromRes(getContext(), R.mipmap.read_wxicon), left1 + pMoney.measureText("支付方式") + 120, bottom + 50, null);
        pTitle.setTextSize(30);
        //绘制微信支付
        canvas.drawText("微信支付", left1 + pMoney.measureText("支付方式") + 200, bottom + 100, pTitle);

        // 提示
        pMoney.setTextSize(28);
        canvas.drawText("(1元=100笛笛币)", left1 + pMoney.measureText("支付方式") + 370, bottom + 100, pMoney);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (e.getAction() != MotionEvent.ACTION_DOWN) {
            return false;
        }
        int action = e.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            if (rectf.contains(e.getX(), e.getY())) {
                selNum = "0";
                postInvalidate();
                System.out.println("点击了第一个");
            } else if (rectf2.contains(e.getX(), e.getY())) {
                selNum = "1";
                postInvalidate();
                System.out.println("点击了第二个");
            } else if (rectf3.contains(e.getX(), e.getY())) {
                selNum = "2";
                postInvalidate();
                System.out.println("点击了第三个");
            }
        }
        return false;
    }
}
