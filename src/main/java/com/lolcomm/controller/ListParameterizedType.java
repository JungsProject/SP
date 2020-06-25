package com.lolcomm.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ListParameterizedType implements ParameterizedType {

	private Type type;
	
	public ListParameterizedType(Type type) {
		this.type = type;
	}
	
	@Override
	public Type[] getActualTypeArguments() {
		// TODO Auto-generated method stub
		return new Type[] {type};
	}

	@Override
	public Type getOwnerType() {
		// TODO Auto-generated method stub
		return ArrayList.class;
	}

	@Override
	public Type getRawType() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
