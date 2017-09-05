package com.ecomm.order.domain.functions;

@FunctionalInterface
public interface Function2<T, U, V> {

	public V apply(T t, U u);
}
