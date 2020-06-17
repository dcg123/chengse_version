package com.lantianle.app.modules.mine.page;


import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.android.baselibrary.base.standard.YQApi;
import com.android.baselibrary.service.bean.user.ProtocolBean;
import com.android.baselibrary.widget.title.TitleBuilder;
import com.lantianle.app.R;
import com.lantianle.app.application.IBaseActivity;
import com.lantianle.app.modules.mine.presenter.ProtocolPresenter;
import com.lantianle.app.modules.mine.view.ProtocolView;

import butterknife.BindView;


@YQApi(
        swipeback = false,
        openAnimation = -1,
        closAnimatione = -1
)
public class ProtocolActivity extends IBaseActivity implements ProtocolView {

    private ProtocolPresenter mProtocolPresenter;
    @BindView(R.id.p_text_view)
    TextView pTextView;
    @Override
    protected int getLayoutView() {
        return R.layout.activity_protocol;
    }

    @Override
    protected void onTitleClickListen(TitleBuilder.TitleButton clicked) {
        switch (clicked) {
            case LEFT:
                finish();
                break;
            case MIDDLE:
                break;
            case RIGHT:
                break;
        }
    }

    @Override
    public void initToolBar(TitleBuilder mTitleBuilder) {
        mTitleBuilder.setMiddleTitleText("用户协议")
                .setLeftDrawable(R.mipmap.ic_back_brown);
    }

    @Override
    public void initUiAndListener() {
        mProtocolPresenter = new ProtocolPresenter(this);
        mProtocolPresenter.fetchData();
        pTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    public void refresh(ProtocolBean protocolBean) {
        pTextView.setText(protocolBean.getProtocolText());
    }
}
