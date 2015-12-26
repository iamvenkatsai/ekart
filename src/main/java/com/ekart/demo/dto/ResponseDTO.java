package com.ekart.demo.dto;

public class ResponseDTO<T> {
	
	private Boolean success;
	private Message message;
	private T result;
	
	public ResponseDTO() {
		super();
	}

	public ResponseDTO(ResponseDTOBuilder<T> responseDTOBuilder) {
		
		this.success=responseDTOBuilder.success;
		this.message=responseDTOBuilder.message;
		this.result=responseDTOBuilder.result;
		
	}

	public static class ResponseDTOBuilder<T>
	{
		private Boolean success;
		private Message message;
		private T result;
		
		public ResponseDTOBuilder() {
			super();
		}

		public ResponseDTOBuilder(Boolean success, Message message, T result) {
			super();
			this.success = success;
			this.message = message;
			this.result = result;
		}
		
		public ResponseDTOBuilder<T> success(Boolean success)
		{
			this.success=success;
			return this;
		}
		
		public ResponseDTOBuilder<T> message(Message message)
		{
			this.message=message;
			return this;
		}
		
		public ResponseDTOBuilder<T> result(T result)
		{
			this.result=result;
			return this;
		}
		
		public ResponseDTO<T> build()
		{
			return new ResponseDTO<T>(this);
		}
	}
	
	public static class Message
	{
		private String title;
		private String reason;
		
		public Message(String title, String reason) {
			super();
			this.title = title;
			this.reason = reason;
		}
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	
}
