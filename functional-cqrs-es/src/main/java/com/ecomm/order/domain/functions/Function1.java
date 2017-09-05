package com.ecomm.order.domain.functions;

@FunctionalInterface
public interface Function1<T, U> {

	public U apply(T t);
}
