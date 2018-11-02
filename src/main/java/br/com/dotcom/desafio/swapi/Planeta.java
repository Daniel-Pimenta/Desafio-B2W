package br.com.dotcom.desafio.swapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Planeta {

	private long count;
	private String next;
	private String previous;
	private List<Result> results;
	
	public Planeta() {
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "{  \r\n" + "   'count':1,\r\n" + "   'next':null,\r\n" + "   'previous':null,\r\n" + "   'results':[ ] ";
	}

}
