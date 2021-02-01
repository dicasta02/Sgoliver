package com.softpolaris.sgoliver.ui.base;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class BasePresenter<T extends BaseView> {
    private T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

    public T getView() {
        return view;
    }
}