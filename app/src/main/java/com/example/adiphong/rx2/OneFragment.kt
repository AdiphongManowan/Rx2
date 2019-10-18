package com.example.adiphong.rx2

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.sql.DriverManager.println
import java.util.concurrent.TimeUnit

class OneFragment : Fragment() {

    private var mainActivity: MainActivity? = null

    private var loadingViewDialog: LoadingViewDialog? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_one, container, false)

        loadingViewDialog = LoadingViewDialog(activity)

        val button = view.findViewById<Button>(R.id.next_button)

        button.setOnClickListener {
            val blankFragment = BlankFragment.newInstance()
            val tag = "blankFragment"
            mainActivity!!.replaceFragment(blankFragment, tag)
        }
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("------------------------ onActivityCreated")

//        Observable.just(randomInteger)
//                .delay(10, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe { __ -> loadingViewDialog!!.showLoading() }
//                .doFinally { loadingViewDialog!!.dismissLoading() }
//                .subscribe { longTimed -> Log.d("---------- tag", "&&&& on timer") }

//        Observable.create<Int> { emitter ->
//            if (!emitter.isDisposed) {
//                val randomInteger = (1..100).shuffled().last()
//                emitter.onNext(randomInteger)
//                println("------------------ randomInteger $randomInteger")
//
//            }
//        }
//                .repeatWhen { t ->
//                    println("------------------------ repeatWhen $t ")
//                    t.delay(5, TimeUnit.SECONDS)
//                }
//                Observable.just((1..100).shuffled().last())
//                                        .repeatWhen { t ->
//                    println("------------------------ repeatWhen $t ")
//                    t.delay(5, TimeUnit.SECONDS)
//                }
//                .takeUntil { t: Int ->
//                    println("------------------------ takeUntil $t ")
//                    t == 10
//                }
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe { _ -> loadingViewDialog!!.showLoading() }
//                .doFinally {
//                    loadingViewDialog!!.dismissLoading()
//                }
//                .subscribe { longTimed ->
//                    Log.d("---------- tag", "finish")
//                }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (activity is MainActivity) {
            mainActivity = activity as MainActivity
        }
    }

    companion object {

        fun newInstance(): OneFragment {
            val fragment = OneFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }
}
