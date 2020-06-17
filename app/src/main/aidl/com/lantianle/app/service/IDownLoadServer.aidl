// IDownLoadServer.aidl
package com.lantianle.app.service;
import com.lantianle.app.service.DownLoadProgress;
import com.lantianle.app.service.AnalysisComplete;
interface IDownLoadServer {

    void start(String url,String name,String cover,String videoId);//开始下载
    void pause(String id,String url);//暂停下载
    void error(String url);//下载失败
    void delete(String url);//删除下载
    void resume(String id,String url);//再次下载
    void setProgress(in DownLoadProgress downLoadProgress);
    void setAnalysis(in AnalysisComplete analysisComplete);
}
