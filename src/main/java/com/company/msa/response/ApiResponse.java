package com.company.msa.response;

public class ApiResponse<T> {
    private boolean success; // 요청 성공 여부
    private String message; // 응답 메시지
    private T data; // 실제 응답 데이터

    // 생성자
    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }


    // 정적 메서드로 생성 편의 제공
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, "성공", data);
    }

    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(false, message, null);
    }

    // Getter (Lombok 없이 직접 작성하면 필요)
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public T getData() { return data; }

}
