package consumer;

public class Greeting {
	private long id;
	private String content;
	
	public Greeting() {}
	
	public Greeting(long l, String content) {
		super();
		this.id = l;
		this.content = content;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String toString() {
		return "{ id : "+this.getId()
				+"\ncontent : "+this.getContent()
				+"}";
	}

}
