package com.example.news_info.view;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.Paint.Style;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;

import com.example.news_info.R;

import java.util.Locale;

public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] ATTRS = new int[]{16842901, 16842904};
    private LayoutParams defaultTabLayoutParams;
    private LayoutParams expandedTabLayoutParams;
    private final PagerSlidingTabStrip.PageListener pageListener;
    public OnPageChangeListener delegatePageListener;
    private LinearLayout tabsContainer;
    private ViewPager pager;
    private int tabCount;
    private int currentPosition;
    private float currentPositionOffset;
    private Paint rectPaint;
    private Paint dividerPaint;
    private int indicatorColor;
    private int underlineColor;
    private int dividerColor;
    private boolean shouldExpand;
    private boolean textAllCaps;
    private int scrollOffset;
    private int indicatorHeight;
    private int underlineHeight;
    private int dividerPadding;
    private int tabPadding;
    private int dividerWidth;
    private int tabTextSize;
    private int tabTextColor;
    private Typeface tabTypeface;
    private int tabTypefaceStyle;
    private int lastScrollX;
    private int tabBackgroundResId;
    private Locale locale;

    //被选中的位置颜色大小
    private int selectionPosition;
    private int selectionTextSize = 18;
    private int selectionTextColor = Color.BLUE;


    public PagerSlidingTabStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.pageListener = new PagerSlidingTabStrip.PageListener();
        this.currentPosition = 0;
        this.currentPositionOffset = 0.0F;
        this.indicatorColor = -10066330;
        this.underlineColor = 436207616;
        this.dividerColor = 436207616;
        this.shouldExpand = false;
        this.textAllCaps = true;
        this.scrollOffset = 52;
        this.indicatorHeight = 8;
        this.underlineHeight = 2;
        this.dividerPadding = 12;
        this.tabPadding = 24;
        this.dividerWidth = 1;
        this.tabTextSize = 12;
        this.tabTextColor = -10066330;
        this.tabTypeface = null;
        this.tabTypefaceStyle = 1;
        this.lastScrollX = 0;
        this.tabBackgroundResId = R.drawable.background_tab;
        this.setFillViewport(true);
        this.setWillNotDraw(false);
        this.tabsContainer = new LinearLayout(context);
        this.tabsContainer.setOrientation(LinearLayout.HORIZONTAL);
        this.tabsContainer.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1));
        this.addView(this.tabsContainer);
        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) this.scrollOffset, dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) this.indicatorHeight, dm);
        this.underlineHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) this.underlineHeight, dm);
        this.dividerPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) this.dividerPadding, dm);
        this.tabPadding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) this.tabPadding, dm);
        this.dividerWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (float) this.dividerWidth, dm);
        this.tabTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, (float) this.tabTextSize, dm);
        TypedArray a = context.obtainStyledAttributes(attrs, ATTRS);
        this.tabTextSize = a.getDimensionPixelSize(0, this.tabTextSize);
        this.tabTextColor = a.getColor(1, this.tabTextColor);
        a.recycle();
        a = context.obtainStyledAttributes(attrs, R.styleable.PagerSlidingTabStrip);
        this.indicatorColor = a.getColor(R.styleable.PagerSlidingTabStrip_pstsIndicatorColor, this.indicatorColor);
        this.underlineColor = a.getColor(R.styleable.PagerSlidingTabStrip_pstsUnderlineColor, this.underlineColor);
        this.dividerColor = a.getColor(R.styleable.PagerSlidingTabStrip_pstsDividerColor, this.dividerColor);
        this.indicatorHeight = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsIndicatorHeight, this.indicatorHeight);
        this.underlineHeight = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsUnderlineHeight, this.underlineHeight);
        this.dividerPadding = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsDividerPadding, this.dividerPadding);
        this.tabPadding = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsTabPaddingLeftRight, this.tabPadding);
        this.tabBackgroundResId = a.getResourceId(R.styleable.PagerSlidingTabStrip_pstsTabBackground, this.tabBackgroundResId);
        this.shouldExpand = a.getBoolean(R.styleable.PagerSlidingTabStrip_pstsShouldExpand, this.shouldExpand);
        this.scrollOffset = a.getDimensionPixelSize(R.styleable.PagerSlidingTabStrip_pstsScrollOffset, this.scrollOffset);
        this.textAllCaps = a.getBoolean(R.styleable.PagerSlidingTabStrip_pstsTextAllCaps, this.textAllCaps);
        a.recycle();
        this.rectPaint = new Paint();
        this.rectPaint.setAntiAlias(true);
        this.rectPaint.setStyle(Style.FILL);
        this.dividerPaint = new Paint();
        this.dividerPaint.setAntiAlias(true);
        this.dividerPaint.setStrokeWidth((float) this.dividerWidth);
        this.defaultTabLayoutParams = new LayoutParams(-2, -1);
        this.expandedTabLayoutParams = new LayoutParams(0, -1, 1);
        if (this.locale == null) {
            this.locale = this.getResources().getConfiguration().locale;
        }

    }

    public void setViewPager(ViewPager pager) {
        this.pager = pager;
        if (pager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        } else {
            pager.setOnPageChangeListener(this.pageListener);
            this.notifyDataSetChanged();
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener listener) {
        this.delegatePageListener = listener;
    }

    public void notifyDataSetChanged() {
        this.tabsContainer.removeAllViews();
        this.tabCount = this.pager.getAdapter().getCount();

        for (int i = 0; i < this.tabCount; ++i) {
            if (this.pager.getAdapter() instanceof PagerSlidingTabStrip.IconTabProvider) {
                this.addIconTab(i, ((PagerSlidingTabStrip.IconTabProvider) this.pager.getAdapter()).getPageIconResId(i));
            } else {
                this.addTextTab(i, this.pager.getAdapter().getPageTitle(i).toString());
            }
        }

        this.updateTabStyles();
        this.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @SuppressLint({"NewApi"})
            public void onGlobalLayout() {
                if (VERSION.SDK_INT < 16) {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.pager.getCurrentItem();
                PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.currentPosition, 0);
            }
        });
    }

    private void addTextTab(int position, String title) {
        TextView tab = new TextView(this.getContext());
        tab.setText(title);
        tab.setGravity(17);
        tab.setSingleLine();
        this.addTab(position, tab);
    }

    private void addIconTab(int position, int resId) {
        ImageButton tab = new ImageButton(this.getContext());
        tab.setImageResource(resId);
        this.addTab(position, tab);
    }

    private void addTab(final int position, View tab) {
        tab.setFocusable(true);
        tab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PagerSlidingTabStrip.this.pager.setCurrentItem(position);
            }
        });
        tab.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        this.tabsContainer.addView(tab, position, this.shouldExpand ? this.expandedTabLayoutParams : this.defaultTabLayoutParams);
    }

    private void updateTabStyles() {
        for (int i = 0; i < this.tabCount; ++i) {
            View v = this.tabsContainer.getChildAt(i);
            v.setBackgroundResource(this.tabBackgroundResId);
            if (v instanceof TextView) {
                TextView tab = (TextView) v;
                tab.setTextSize(0, (float) this.tabTextSize);
                tab.setTypeface(this.tabTypeface, this.tabTypefaceStyle);
                tab.setTextColor(this.tabTextColor);
                if (this.textAllCaps) {
                    if (VERSION.SDK_INT >= 14) {
                        tab.setAllCaps(true);
                    } else {
                        tab.setText(tab.getText().toString().toUpperCase(this.locale));
                    }
                }
//            判断这个位置是否是被选中的位置，如果是，就改变文字颜色和文字大小
                if (i == selectionPosition) {
                    tab.setTextColor(selectionTextColor);
                    tab.setTextSize(selectionTextSize);
                }
            }
        }

    }

    private void scrollToChild(int position, int offset) {
        if (this.tabCount != 0) {
            int newScrollX = this.tabsContainer.getChildAt(position).getLeft() + offset;
            if (position > 0 || offset > 0) {
                newScrollX -= this.scrollOffset;
            }

            if (newScrollX != this.lastScrollX) {
                this.lastScrollX = newScrollX;
                this.scrollTo(newScrollX, 0);
            }

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.isInEditMode() && this.tabCount != 0) {
            int height = this.getHeight();
            this.rectPaint.setColor(this.indicatorColor);
            View currentTab = this.tabsContainer.getChildAt(this.currentPosition);
            float lineLeft = (float) currentTab.getLeft();
            float lineRight = (float) currentTab.getRight();
            if (this.currentPositionOffset > 0.0F && this.currentPosition < this.tabCount - 1) {
                View nextTab = this.tabsContainer.getChildAt(this.currentPosition + 1);
                float nextTabLeft = (float) nextTab.getLeft();
                float nextTabRight = (float) nextTab.getRight();
                lineLeft = this.currentPositionOffset * nextTabLeft + (1.0F - this.currentPositionOffset) * lineLeft;
                lineRight = this.currentPositionOffset * nextTabRight + (1.0F - this.currentPositionOffset) * lineRight;
            }

            canvas.drawRect(lineLeft, (float) (height - this.indicatorHeight), lineRight, (float) height, this.rectPaint);
            this.rectPaint.setColor(this.underlineColor);
            canvas.drawRect(0.0F, (float) (height - this.underlineHeight), (float) this.tabsContainer.getWidth(), (float) height, this.rectPaint);
            this.dividerPaint.setColor(this.dividerColor);

            for (int i = 0; i < this.tabCount - 1; ++i) {
                View tab = this.tabsContainer.getChildAt(i);
                canvas.drawLine((float) tab.getRight(), (float) this.dividerPadding, (float) tab.getRight(), (float) (height - this.dividerPadding), this.dividerPaint);
            }

        }
    }

    public void setIndicatorColor(int indicatorColor) {
        this.indicatorColor = indicatorColor;
        this.invalidate();
    }

    public void setIndicatorColorResource(int resId) {
        this.indicatorColor = this.getResources().getColor(resId);
        this.invalidate();
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public void setIndicatorHeight(int indicatorLineHeightPx) {
        this.indicatorHeight = indicatorLineHeightPx;
        this.invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public void setUnderlineColor(int underlineColor) {
        this.underlineColor = underlineColor;
        this.invalidate();
    }

    public void setUnderlineColorResource(int resId) {
        this.underlineColor = this.getResources().getColor(resId);
        this.invalidate();
    }

    public int getUnderlineColor() {
        return this.underlineColor;
    }

    public void setDividerColor(int dividerColor) {
        this.dividerColor = dividerColor;
        this.invalidate();
    }

    public void setDividerColorResource(int resId) {
        this.dividerColor = this.getResources().getColor(resId);
        this.invalidate();
    }

    public int getDividerColor() {
        return this.dividerColor;
    }

    public void setUnderlineHeight(int underlineHeightPx) {
        this.underlineHeight = underlineHeightPx;
        this.invalidate();
    }

    public int getUnderlineHeight() {
        return this.underlineHeight;
    }

    public void setDividerPadding(int dividerPaddingPx) {
        this.dividerPadding = dividerPaddingPx;
        this.invalidate();
    }

    public int getDividerPadding() {
        return this.dividerPadding;
    }

    public void setScrollOffset(int scrollOffsetPx) {
        this.scrollOffset = scrollOffsetPx;
        this.invalidate();
    }

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public void setShouldExpand(boolean shouldExpand) {
        this.shouldExpand = shouldExpand;
        this.requestLayout();
    }

    public boolean getShouldExpand() {
        return this.shouldExpand;
    }

    public boolean isTextAllCaps() {
        return this.textAllCaps;
    }

    public void setAllCaps(boolean textAllCaps) {
        this.textAllCaps = textAllCaps;
    }

    public void setTextSize(int textSizePx) {
        this.tabTextSize = textSizePx;
        this.updateTabStyles();
    }

    public int getTextSize() {
        return this.tabTextSize;
    }

    public void setTextColor(int textColor) {
        this.tabTextColor = textColor;
        this.updateTabStyles();
    }

    public void setTextColorResource(int resId) {
        this.tabTextColor = this.getResources().getColor(resId);
        this.updateTabStyles();
    }

    public int getTextColor() {
        return this.tabTextColor;
    }

    public void setTypeface(Typeface typeface, int style) {
        this.tabTypeface = typeface;
        this.tabTypefaceStyle = style;
        this.updateTabStyles();
    }

    public void setTabBackground(int resId) {
        this.tabBackgroundResId = resId;
    }

    public int getTabBackground() {
        return this.tabBackgroundResId;
    }

    public void setTabPaddingLeftRight(int paddingPx) {
        this.tabPadding = paddingPx;
        this.updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        PagerSlidingTabStrip.SavedState savedState = (PagerSlidingTabStrip.SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.currentPosition = savedState.currentPosition;
        this.requestLayout();
    }

    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        PagerSlidingTabStrip.SavedState savedState = new PagerSlidingTabStrip.SavedState(superState);
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    static class SavedState extends BaseSavedState {
        int currentPosition;
        public static final Creator<PagerSlidingTabStrip.SavedState> CREATOR = new Creator<PagerSlidingTabStrip.SavedState>() {
            @Override
            public PagerSlidingTabStrip.SavedState createFromParcel(Parcel in) {
                return new PagerSlidingTabStrip.SavedState(in);
            }

            @Override
            public PagerSlidingTabStrip.SavedState[] newArray(int size) {
                return new PagerSlidingTabStrip.SavedState[size];
            }
        };

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.currentPosition = in.readInt();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPosition);
        }
    }

    private class PageListener implements OnPageChangeListener {
        private PageListener() {
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            PagerSlidingTabStrip.this.currentPosition = position;
            PagerSlidingTabStrip.this.currentPositionOffset = positionOffset;
            PagerSlidingTabStrip.this.scrollToChild(position, (int) (positionOffset * (float) PagerSlidingTabStrip.this.tabsContainer.getChildAt(position).getWidth()));
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == 0) {
                PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.pager.getCurrentItem(), 0);
            }

            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrollStateChanged(state);
            }

        }

        @Override
        public void onPageSelected(int position) {

//TODO
            selectionPosition = position;
            updateTabStyles();

            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageSelected(position);
            }

        }
    }

    public interface IconTabProvider {
        int getPageIconResId(int var1);
    }
}
