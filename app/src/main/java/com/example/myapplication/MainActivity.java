package com.example.myapplication;

import android.graphics.YuvImage;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;


public class MainActivity extends AppCompatActivity {

    private final static String TAG = "myApp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //asynchSubjectDemo2();
        //behaviorSubjectDemo1();
        //publishedSubjectDemo1();
        //publishSubjectDemo2();
        replaySubjectDemo1()




    }

    void asynchSubjectDemo1(){
        Observable<String> observable=Observable.just("JAVA","KOTLIN","XML","JSON");
        observable.subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread());

        AsyncSubject<String> asyncSubject=AsyncSubject.create();

        observable.subscribe(asyncSubject);

        asyncSubject.subscribe(getFirstObserver());
        asyncSubject.subscribe(getSecondObserver());
        asyncSubject.subscribe(getThirdObserver());

    }

    void behaviorSubjectDemo1(){
        Observable<String> observable=Observable.just("JAVA","KOTLIN","XML","JSON");
        observable.subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread());

        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();

        observable.subscribe(behaviorSubject);

        behaviorSubject.subscribe(getFirstObserver());
        behaviorSubject.subscribe(getSecondObserver());
        behaviorSubject.subscribe(getThirdObserver());

    }

    void asynchSubjectDemo2(){


        AsyncSubject<String> asyncSubject=AsyncSubject.create();


        asyncSubject.subscribe(getFirstObserver());

        asyncSubject.onNext("JAVA");
        asyncSubject.onNext("KOTLIN");
        asyncSubject.onNext("XML");


        asyncSubject.subscribe(getSecondObserver());
        asyncSubject.onNext("JSON");
        asyncSubject.onComplete();


        asyncSubject.subscribe(getThirdObserver());

    }

    void behaviorSubjectDemo2(){


        BehaviorSubject<String> behaviorSubject=BehaviorSubject.create();


        behaviorSubject.subscribe(getFirstObserver());

        behaviorSubject.onNext("JAVA");
        behaviorSubject.onNext("KOTLIN");
        behaviorSubject.onNext("XML");


        behaviorSubject.subscribe(getSecondObserver());
        behaviorSubject.onNext("JSON");
        behaviorSubject.onComplete();


        behaviorSubject.subscribe(getThirdObserver());

    }

    void publishSubjectDemo2(){


        PublishSubject<String> publishSubject=PublishSubject.create();


        publishSubject.subscribe(getFirstObserver());

        publishSubject.onNext("JAVA");
        publishSubject.onNext("KOTLIN");
        publishSubject.onNext("XML");


        publishSubject.subscribe(getSecondObserver());
        publishSubject.onNext("JSON");
        publishSubject.onComplete();


        publishSubject.subscribe(getThirdObserver());

    }

    void publishedSubjectDemo1(){

        Observable<String> observable = Observable.just("JAVA","KOTLIN","XML","JSON")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        PublishSubject<String> publishSubject = PublishSubject.create();

        observable.subscribe(publishSubject);

        publishSubject.subscribe(getThirdObserver());
        publishSubject.subscribe(getSecondObserver());
        publishSubject.subscribe(getThirdObserver());

    }

    void replaySubjectDemo1(){

        Observable<String> observable = Observable.just("JAVA","KOTLIN","XML","JSON")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        ReplaySubject<String> replaySubject = ReplaySubject.create();

        observable.subscribe(replaySubject);

        replaySubject.subscribe(getThirdObserver());
        replaySubject.subscribe(getSecondObserver());
        replaySubject.subscribe(getThirdObserver());

    }

    private Observer<String> getFirstObserver() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "First Ob server OnSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "First observer Recieved" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "First Observer onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "First Observer onComplete");

            }
        };
        return observer;
    }

    private Observer<String> getSecondObserver() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "Second Ob server OnSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "Second observer Recieved" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "Second Observer onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "Second Observer onComplete");

            }
        };
        return observer;
    }

    private Observer<String> getThirdObserver() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.i(TAG, "Third Ob server OnSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.i(TAG, "Third observer Recieved" + s);
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG, "Third Observer onError");
            }

            @Override
            public void onComplete() {
                Log.i(TAG, "Third Observer onComplete");

            }
        };
        return observer;
    }
}
