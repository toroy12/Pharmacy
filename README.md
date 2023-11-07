# Pharmacy
KAKAO API를 이용한 가까운 약국 길찾기 프로젝트

Pharmacy-Recommendation

외부 API(카카오 주소 검색 API)와 공공 데이터(약국 현황 정보)를 활용함으로써 혼자 개발하고 마무리 되는 프로젝트가 아닌 실제 서비스 가능한 수준의 프로젝트를 경험 해봅니다.

추천된 약국의 길 안내는 카카오 지도 및 로드뷰 바로가기 URL로 제공 됩니다.

요구사항 분석
약국 찾기 서비스 요구사항
약국 현황 데이터(공공 데이터)를 관리하고 있다 라고 가정하고, 약국 현황 데이터는 위도 경도의 위치 정보 데이터를 가지고 있습니다.

해당 서비스로 주소 정보를 입력하여 요청하면 위치 기준에서 가까운 약국 3 곳을 추출 합니다.

주소는 도로명 주소 또는 지번을 입력하여 요청 받습니다.

정확한 주소를 입력 받기 위해 Kakao 우편번호 서비스 사용
주소는 정확한 상세 주소(동, 호수)를 제외한 주소 정보를 이용하여 추천합니다.

ex) 서울 성북구 종암로 10길
입력 받은 주소를 위도, 경도로 변환 하여 기존 약국 데이터와 비교 및 가까운 약국을 찾습니다.

지구는 평면이 아니기 때문에, 구면에서 두 점 사이의 최단 거리 구하는 공식이 필요
두 위 경도 좌표 사이의 거리를 haversine formula로 계산
지구가 완전한 구형이 아니 므로 아주 조금의 오차가 있습니다.
입력한 주소 정보에서 정해진 반경(10km) 내에 있는 약국만 추천 합니다.

추출한 약국 데이터는 길안내 URL 및 로드뷰 URL로 제공 합니다.

ex)
길안내 URL : https://map.kakao.com/link/map/우리회사,37.402056,127.108212
로드뷰 URL : https://map.kakao.com/link/roadview/37.402056,127.108212
길안내 URL은 고객에게 제공 되기 때문에 가독성을 위해 shorten url로 제공 합니다.

ex) http://localhost:8080/dir/nqxtX
base62를 통한 인코딩
shorten url의 유효 기간은 30일로 제한 한다.

Spring Data JPA를 이용한 CRUD 메서드 구현하기
카카오 주소검색 API 연동하여 주소를 위도, 경도로 변환하기
추천 결과를 카카오 지도 URL로 연동하여 제공하기
공공 데이터를 활용하여 개발하기 (약국 현황 데이터)
thymeleaf를 이용한 간단한 View 만들기
Spring retry를 이용한 재처리 구현하기 (카카오 API의 네트워크 오류 등에 대한 재처리)
base62를 이용한 shorten url 개발하기 (길안내 URL)


JDK 18
Spring Boot 2.6.7
Spring Data JPA
Maven
thymeleaf
Lombok
Github
MYSQL

Result
![image](https://github.com/toroy12/Pharmacy/assets/96565041/4518efd3-2172-44b6-b6f2-5f0053fad2bb)


![image](https://github.com/toroy12/Pharmacy/assets/96565041/c8c1712e-3ae5-4790-b8cc-b929e84757c5)


