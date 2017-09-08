package com.ecomm.order.domain.functions;

@FunctionalInterface
public interface Function3<T, U> {

	public U append(T t);
}
