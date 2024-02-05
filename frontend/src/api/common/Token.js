export async function renewToken(accessToken) {
  await fetch("/api/v1/member", {
    method: "PUT", // 요청 방식
    headers: {
      "Content-Type": "application/json", // 컨텐츠 타입 설정
    },
    body: JSON.stringify(accessToken), // 데이터를 문자열로 변환하여 전송
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      return response.json().data;
    })
    .catch((error) => {
      throw error;
    });
}

export function isTokenExpired() {
  const tokenTimestamp = localStorage.getItem("tokenTimestamp");
  if (!tokenTimestamp) return true;

  const now = Date.now();
  const timeElapsed = (now - tokenTimestamp) / 1000 / 60 / 60; // 분 단위로 변환

  // 14분이 지났으면 갱신 필요
  return timeElapsed > 5;
}
