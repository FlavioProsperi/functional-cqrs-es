package com.ecomm.order.domain.functions;

@FunctionalInterface
public interface Function3<T, U> {

	public void append(T t, U u);
}
