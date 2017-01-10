package ie.gmit.sw;

public class Result implements Resultable
{
	private String plainText;
	private int key;
	private double score;

	public Result(String plainText, int key, double score) {
		super();
		this.plainText = plainText;
		this.key = key;
		this.score = score;
	}

	public Result(Result plainText2) {
		// TODO Auto-generated constructor stub
	}

	//Get and set methods to decrypt to plainText
	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}

	//Get and set methods for the key
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}


	}
