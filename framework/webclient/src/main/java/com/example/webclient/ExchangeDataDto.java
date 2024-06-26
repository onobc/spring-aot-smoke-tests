package com.example.webclient;

public class ExchangeDataDto {

	private String url;

	private String method;

	public ExchangeDataDto() {
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "ExchangeDataDto{" + "url='" + url + '\'' + ", method='" + method + '\'' + '}';
	}

}
