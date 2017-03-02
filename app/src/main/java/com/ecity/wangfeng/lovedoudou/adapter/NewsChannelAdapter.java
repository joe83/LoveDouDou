package com.ecity.wangfeng.lovedoudou.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ecity.wangfeng.lovedoudou.R;
import com.ecity.wangfeng.lovedoudou.entity.news.NewsChannelTable;
import com.ecity.wangfeng.lovedoudou.event.ChannelItemMoveEvent;
import com.ecity.wangfeng.lovedoudou.listener.ItemDragHelperCallback;
import com.ecity.wangfeng.lovedoudou.util.ClickUtil;
import com.ecity.wangfeng.lovedoudou.util.RxBus;
import com.socks.library.KLog;

import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 频道适配器
 *
 * @version 1.0 Created by Administrator on 2016/11/22.
 */

public class NewsChannelAdapter extends BaseRecyclerViewAdapter<NewsChannelTable> implements ItemDragHelperCallback.OnItemMoveListener {

	private static final int TYPE_CHANNEL_FIXED    = 0;
	private static final int TYPE_CHANNEL_NO_FIXED = 1;

	private ItemDragHelperCallback mItemDragHelperCallback;

	private boolean isEdit = false;

	public void setEdit(boolean edit) {
		isEdit = edit;
		notifyDataSetChanged();
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setItemDragHelperCallback(ItemDragHelperCallback itemDragHelperCallback) {
		this.mItemDragHelperCallback = itemDragHelperCallback;
	}

	public NewsChannelAdapter(List<NewsChannelTable> list) {
		super(list);
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		NewsChannelViewHolder holder = new NewsChannelViewHolder(getView(parent, R.layout.adapter_news_channel_item));
		handleLongPress(holder);
		handleOnClick(holder);
		return holder;
	}

	private void handleLongPress(final NewsChannelViewHolder holder) {
		if (mItemDragHelperCallback != null) {
			holder.itemView.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					NewsChannelTable newsChannel = mList.get(holder.getLayoutPosition());
					boolean isChannelFixed = newsChannel.isNewsChannelFixed();
					if (isChannelFixed) {
						mItemDragHelperCallback.setLongPressEnabled(false);
					} else {
						mItemDragHelperCallback.setLongPressEnabled(true);
					}
					return false;
				}
			});
		}
	}

	private void handleOnClick(final NewsChannelViewHolder holder) {
		if (mOnItemClickListener != null) {
			holder.itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (!ClickUtil.isFastDoubleClick()) {
						mOnItemClickListener.OnItemClickListener(v, holder.getLayoutPosition());
					}
				}
			});
		}
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
		super.onBindViewHolder(holder, position);
		NewsChannelTable newsChannel = mList.get(position);
		NewsChannelViewHolder viewHolder = (NewsChannelViewHolder) holder;
		viewHolder.tvNewsChannelName.setText(newsChannel.getNewsChannelName());
		int colorId;
		if (newsChannel.isNewsChannelFixed()) {
			colorId = R.color.text_color_secondary;
		} else {
			colorId = R.color.text_color_primary;
		}
		viewHolder.tvNewsChannelName.setTextColor(ContextCompat.getColor(holder.itemView.getContext(), colorId));
		if (!newsChannel.isNewsChannelFixed() && newsChannel.isNewsChannelSelect() && isEdit) {
			viewHolder.ivDelete.setVisibility(View.VISIBLE);
		} else {
			viewHolder.ivDelete.setVisibility(View.GONE);
		}
	}

	@Override
	public boolean onItemMove(int fromPosition, int toPosition) {
		KLog.e("onItemMove", "fromPosition=" + fromPosition + "---toPosition=" + toPosition);
		if (isChannelFixed(fromPosition, toPosition)) {
			return false;
		}
		Collections.swap(mList, fromPosition, toPosition);
		notifyItemMoved(fromPosition, toPosition);
		RxBus.getInstance().post(new ChannelItemMoveEvent(fromPosition, toPosition));
		return true;
	}

	private boolean isChannelFixed(int fromPosition, int toPosition) {
		return mList.get(fromPosition).isNewsChannelFixed() || mList.get(toPosition).isNewsChannelFixed();
	}

	@Override
	public int getItemViewType(int position) {
		if (mList.get(position).isNewsChannelFixed()) {
			return TYPE_CHANNEL_FIXED;
		} else {
			return TYPE_CHANNEL_NO_FIXED;
		}
	}

	class NewsChannelViewHolder extends RecyclerView.ViewHolder {

		@Bind(R.id.tv_news_channel_name)
		TextView  tvNewsChannelName;
		@Bind(R.id.iv_delete)
		ImageView ivDelete;

		public NewsChannelViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}