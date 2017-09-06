package cn.jzvd.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.squareup.picasso.Picasso;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import cn.jzvd.demo.CustomView.JZVideoPlayerStandardAutoCompleteAfterFullscreen;
import cn.jzvd.demo.CustomView.JZVideoPlayerStandardShowShareButtonAfterFullscreen;
import cn.jzvd.demo.CustomView.JZVideoPlayerStandardShowTextureViewAfterAutoComplete;
import cn.jzvd.demo.CustomView.JZVideoPlayerStandardShowTitleAfterFullscreen;

/**
 * Created by Nathen on 16/7/31.
 */
public class UISmallChangeActivity extends AppCompatActivity {
    JZVideoPlayerStandardShowShareButtonAfterFullscreen jcVideoPlayerStandardWithShareButton;
    JZVideoPlayerStandardShowTitleAfterFullscreen jcVideoPlayerStandardShowTitleAfterFullscreen;
    JZVideoPlayerStandardShowTextureViewAfterAutoComplete jcVideoPlayerStandardShowTextureViewAfterAutoComplete;
    JZVideoPlayerStandardAutoCompleteAfterFullscreen jcVideoPlayerStandardAutoCompleteAfterFullscreen;

    JZVideoPlayerStandard jcVideoPlayerStandard_1_1, jcVideoPlayerStandard_16_9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("SmallChangeUI");
        setContentView(R.layout.activity_ui_small_change);

        jcVideoPlayerStandardWithShareButton = (JZVideoPlayerStandardShowShareButtonAfterFullscreen) findViewById(R.id.custom_videoplayer_standard_with_share_button);
        jcVideoPlayerStandardWithShareButton.setUp(VideoConstant.videoUrlList[3], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子想呼吸");
        Picasso.with(this)
                .load(VideoConstant.videoThumbList[3])
                .into(jcVideoPlayerStandardWithShareButton.thumbImageView);


        jcVideoPlayerStandardShowTitleAfterFullscreen = (JZVideoPlayerStandardShowTitleAfterFullscreen) findViewById(R.id.custom_videoplayer_standard_show_title_after_fullscreen);
        jcVideoPlayerStandardShowTitleAfterFullscreen.setUp(VideoConstant.videoUrlList[4], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子想摇头");
        Picasso.with(this)
                .load(VideoConstant.videoThumbList[4])
                .into(jcVideoPlayerStandardShowTitleAfterFullscreen.thumbImageView);

        jcVideoPlayerStandardShowTextureViewAfterAutoComplete = (JZVideoPlayerStandardShowTextureViewAfterAutoComplete) findViewById(R.id.custom_videoplayer_standard_show_textureview_aoto_complete);
        jcVideoPlayerStandardShowTextureViewAfterAutoComplete.setUp(VideoConstant.videoUrlList[5], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子想旅行");
        Picasso.with(this)
                .load(VideoConstant.videoThumbList[5])
                .into(jcVideoPlayerStandardShowTextureViewAfterAutoComplete.thumbImageView);

        jcVideoPlayerStandardAutoCompleteAfterFullscreen = (JZVideoPlayerStandardAutoCompleteAfterFullscreen) findViewById(R.id.custom_videoplayer_standard_aoto_complete);
        jcVideoPlayerStandardAutoCompleteAfterFullscreen.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子没来");
        Picasso.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jcVideoPlayerStandardAutoCompleteAfterFullscreen.thumbImageView);

        jcVideoPlayerStandard_1_1 = (JZVideoPlayerStandardAutoCompleteAfterFullscreen) findViewById(R.id.jc_videoplayer_1_1);
        jcVideoPlayerStandard_1_1.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子有事吗");
        Picasso.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jcVideoPlayerStandard_1_1.thumbImageView);
        jcVideoPlayerStandard_1_1.widthRatio = 1;
        jcVideoPlayerStandard_1_1.heightRatio = 1;

        jcVideoPlayerStandard_16_9 = (JZVideoPlayerStandardAutoCompleteAfterFullscreen) findViewById(R.id.jc_videoplayer_16_9);
        jcVideoPlayerStandard_16_9.setUp(VideoConstant.videoUrls[0][1], JZVideoPlayer.SCREEN_LAYOUT_NORMAL
                , "嫂子来不了");
        Picasso.with(this)
                .load(VideoConstant.videoThumbs[0][1])
                .into(jcVideoPlayerStandard_16_9.thumbImageView);
        jcVideoPlayerStandard_16_9.widthRatio = 16;
        jcVideoPlayerStandard_16_9.heightRatio = 9;
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}