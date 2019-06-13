package com.example.myapplication;

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
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    private final static String TAG = "myApp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<Integer> myObservable = Observable.range(1,20);

        myObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .buffer(4) // puts for items together 
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Integer> integers) {
                        Log.i(TAG, "Came to OnNext");
                        Log.i(TAG, "Value is " + integers);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });



    }

//        myObserable=myObserable.create(new ObservableOnSubscribe<Student>() {
//            @Override
//            public void subscribe(ObservableEmitter<Student> emitter) throws Exception {
//
//                ArrayList<Student> studentArrayList=getStudents();
//
//                for(Student student:studentArrayList){
//                    emitter.onNext(student);
//                }
//
//                emitter.onComplete();
//            }

//        compositeDisposable.add(
//                myObserable
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
////                        .map(new Function<Student, Student>() {
////                            @Override
////                            public Student apply(Student student) throws Exception {
////
////                                student.setName(student.getName().toUpperCase());
////                                return student;
////                            }
////                        })
////                        .flatMap(new Function<Student, ObservableSource<?>>() {
////                            @Override
////                            public ObservableSource<?> apply(Student student) throws Exception {
////                                return Observable.just(student);
////                            }
////                        })
//                        .concatMap(new Function<Student, ObservableSource<?>>() { //concatMap preservers order of items
//                            @Override
//                            public ObservableSource<?> apply(Student student) throws Exception {
//                                return Observable.just(student);
//                            }
//                        })
//                .subscribeWith(getObserver())
//        );





//    private DisposableObserver getObserver() {
//
//        myObserver = new DisposableObserver<Student>() {
//            @Override
//            public void onNext(Student strings) {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };
//        return myObserver;
//    }

//    private ArrayList<Student> getStudents(){
//        ArrayList<Student> students = new ArrayList<>();
//
//        Student student1 = new Student();
//        student1.setName("Students 1");
//        student1.setEmail("Beefy");
//        student1.setAge(28);
//        students.add(student1);
//
//        Student student2 = new Student();
//        student2.setName("Students 2");
//        student2.setEmail("Cheesy");
//        student2.setAge(34);
//        students.add(student2);
//
//     return students;
//    }
}
