package com.barnettwong.lovedoudou.mvp.contract;

import com.barnettwong.lovedoudou.bean.VideoListBean;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;
import com.jaydenxiao.common.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by wang on 2018/8/8.
 **/
public interface VideoListContract {
    interface Model extends BaseModel {
        Observable<List<VideoListBean.DataBean>> getVideoLists(int type, int page);
    }

    interface View extends BaseView {
        void returnVideoListResult(List<VideoListBean.DataBean> typelist);

    }
    abstract static class Presenter extends BasePresenter<View, Model> {

        public abstract void startVideoListRequest(int type,int page);

    }
}
