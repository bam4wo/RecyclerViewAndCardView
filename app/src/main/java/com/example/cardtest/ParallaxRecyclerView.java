package com.example.cardtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ParallaxRecyclerView extends RecyclerView {

    public ParallaxRecyclerView(@NonNull Context context) {
        super(context, null);
    }

    public ParallaxRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        if(isInEditMode()){
            return;
        }

        setLayoutManager(new LinearLayoutManager(context));

        //利用ItemDecoration實現間隔、重疊效果
        addItemDecoration(new ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull State state) {
                super.getItemOffsets(outRect, view, parent, state); //可通過outRect指定itemView的位置
                //取得目前itemView的位置
                final int currentPosition = parent.getChildLayoutPosition(view);
                //取得最後一個itemView的位置
                final int lastPosition = state.getItemCount()-1;
                if (currentPosition != lastPosition){
                    outRect.bottom = -dp2px(context, 10);
                }
            }
        });

        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if(linearLayoutManager == null){
                    return;
                }
                int firstPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int lastPosition = linearLayoutManager.findLastVisibleItemPosition();
                int visibleCount = lastPosition - firstPosition;

                //重置itemView的位置和高度
                int elevation = 1;
                for(int i = firstPosition - 1; i <= (firstPosition + visibleCount) + 1; i++){
                    View view = linearLayoutManager.findViewByPosition(i);
                    if(view != null){
                        if (view instanceof CardView) {
                            //設置cardView高度，讓每一項搞度比上一項高5dp
                            ((CardView) view).setCardElevation(dp2px(context, elevation));
                            elevation += 5;
                        }
                        //復原itemView位置
                        float translationY = view.getTranslationY();
                        if (i > firstPosition && translationY != 0) {
                            view.setTranslationY(0);
                        }
                    }

                }
                //第一個itemView收合時的差動效果
                View firstView = linearLayoutManager.findViewByPosition(firstPosition);
                if (firstView != null) {
                    float firstViewTop = firstView.getTop();
                    firstView.setTranslationY(-firstViewTop / 2.0f);
                }
            }
        });
    }

    //在xml裡使用dp來設置單位，但在java裡使用的單位是px，所以要做dp到px的轉換
    private int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public ParallaxRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
