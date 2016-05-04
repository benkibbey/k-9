package com.fsck.k9.ui.messageview;


import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fsck.k9.K9;
import com.fsck.k9.R;
import com.fsck.k9.helper.SizeFormatter;
import com.fsck.k9.mail.MessagingException;
import com.fsck.k9.mailstore.AttachmentViewInfo;
import com.fsck.k9.view.ToolableViewAnimator;


public class LockedAttachmentView extends ToolableViewAnimator implements OnClickListener {
    private AttachmentView attachmentView;


    public LockedAttachmentView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public LockedAttachmentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LockedAttachmentView(Context context) {
        super(context);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            return;
        }

        View unlockButton = findViewById(R.id.locked_button);
        unlockButton.setOnClickListener(this);

        attachmentView = (AttachmentView) findViewById(R.id.attachment);
    }

    public void setAttachment(AttachmentViewInfo attachment) throws MessagingException {
        attachmentView.setAttachment(attachment);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.locked_button: {
                showUnlockedView();
                break;
            }
        }
    }

    private void showUnlockedView() {
        setDisplayedChild(1);
    }

    public void setCallback(AttachmentViewCallback attachmentCallback) {
        attachmentView.setCallback(attachmentCallback);
    }
}
