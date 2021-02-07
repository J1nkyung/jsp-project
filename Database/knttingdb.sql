

CREATE TABLE board_list
(
    `blno`   INT  		AUTO_INCREMENT COMMENT 'blno', 
    `bname`  VARCHAR(45)   NOT NULL        COMMENT 'bname', 
    PRIMARY KEY (blno)
);


CREATE TABLE members
(
    `mno`        INT 			AUTO_INCREMENT COMMENT 'mno', 
    `id`         VARCHAR(45)    NOT NULL        COMMENT 'id', 
    `email`      VARCHAR(45)    NOT NULL        COMMENT 'email', 
    `pwd`        VARCHAR(45)    NOT NULL        COMMENT 'pwd', 
    `mname`      VARCHAR(45)    NOT NULL        COMMENT 'mname', 
    `cre_date`  DATETIME	   NOT NULL        COMMENT 'cre_date',
    PRIMARY KEY (mno)
);

CREATE TABLE board
(
    `cno`       INT   AUTO_INCREMENT COMMENT 'cno', 
    `blno`      INT            NOT NULL        COMMENT 'blno', 
    `title`     VARCHAR(45)    NOT NULL        COMMENT 'title', 
    `contents`  VARCHAR(1000)    NOT NULL        COMMENT 'contents',
    `img`  VARCHAR(500)    NULL        COMMENT 'img', 
    `id`        VARCHAR(45)    NOT NULL        COMMENT 'id', 
    `reg_date`  TIMESTAMP DEFAULT NOW()	NOT NULL,
    `view_count` INT 			NOT NULL,
    PRIMARY KEY (cno)
);



ALTER TABLE members
         ADD CONSTRAINT members_id_UNIQUE UNIQUE(id);

ALTER TABLE board
    ADD CONSTRAINT FK_board_id_members_id FOREIGN KEY (id)
        REFERENCES members (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE board
    ADD CONSTRAINT FK_board_blno_board_list_blno FOREIGN KEY (blno)
        REFERENCES board_list (blno) ON DELETE CASCADE ON UPDATE CASCADE;
        
ALTER TABLE members
   MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT
    COMMENT '회원일련번호';
    
INSERT INTO members(id,email,pwd,mname,cre_date)
VALUES ('s1','s1@test.com','1111','아이유',NOW());
INSERT INTO members(id, email,pwd,mname,cre_date)
VALUES ('s2', 's2@test.com','1111','트와이스사나',NOW());
INSERT INTO members(id, email,pwd,mname,cre_date)
VALUES ('s3', 's3@test.com','1111','블랙핑크제니',NOW());
INSERT INTO members(id, email,pwd,mname,cre_date)
VALUES ('s4', 's4@test.com','1111','차은우',NOW());
INSERT INTO members(id, email,pwd,mname,cre_date)
VALUES ('s5', 's5@test.com','1111','박보검',NOW());

INSERT INTO board_list(bname)
VALUES ('공지');

INSERT INTO board_list(bname)
VALUES ('자유게시판');

INSERT INTO board_list(bname)
VALUES ('자료공유');

INSERT INTO board_list(bname)
VALUES ('중고거래');

INSERT INTO board(blno, title, contents, id, view_count)
VALUES (1,'공지사항','등업신청','s1',1);


INSERT INTO board(blno, title, contents, id, view_count)
VALUES (2,'자유게시판','등업신청','s1',2);

INSERT INTO board(blno, title, contents, id, view_count)
VALUES (3,'자료공유','등업신청','s1',2);

INSERT INTO board(blno, title, contents, id, view_count)
VALUES (4,'중고거래','등업신청','s1',2);


CREATE TABLE comment
(
    `comno`        INT          AUTO_INCREMENT COMMENT 'comment number', 
	`cno`    	   INT    		NOT NULL	 COMMENT 'contennts number', 
	`id`        VARCHAR(45)    NOT NULL        COMMENT 'id', 
    `comments`   VARCHAR(200)    NOT NULL        COMMENT 'comment', 
    `comreg_date`  TIMESTAMP      default now()    not null   COMMENT 'comment regdate',
    PRIMARY KEY (comno)
);


ALTER TABLE comment
    ADD CONSTRAINT FK_comment_cno_board_cno FOREIGN KEY (cno)
        REFERENCES board (cno) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE comment
    ADD CONSTRAINT FK_comment_id_members_id FOREIGN KEY (id)
        REFERENCES members (id) ON DELETE CASCADE ON UPDATE CASCADE;        



INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'횐님덜@~ 구경해주셔오들~~','제가 코바늘로 떠보았답니다...^^...','https://3.bp.blogspot.com/-G7BV4XNeJPQ/VeOaFHlIOaI/AAAAAAAANzU/tiq07pVrQCI/s640/2015-08-21%2B22.31.28.jpg','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'겨울맞이 뜨개질을 시작해보려고 해요','실은 다이소에서 샀답니다~','https://file.instiz.net/data/file/20131218/0/b/7/0b7035f1d77d9eb040588d36b2dba2d6.jpg','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'뜨개질하러 가입햇슴다','ㅈㄱㄴ','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'똑똑 여기가 뜨개질 카페인가요?','안뇽하세요? 이번에 처음 가입했습니다! 잘부탁드려요들~~~~','','s2',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'하2','ㅎ2','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'추운겨울 따듯하게 보내세요','ㅈㄱㄴ','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'집콕하니 뜨개질만 하고 있네요^^;;','코로나가 잠잠해지면 같은 취미를 가진 분들끼리 모여서 함께 하는 것도 재밌지 않을까라는 생각이 들어 글을 적어봅니다,,,,','','s2',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'혹시 같이 뜨개질 하실 분 계실까요?(마감)','요런 코바늘 뜨게질이요~ 혹시 모르니 마스크 착용하고 뜨는게 어떨가 싶어요~','https://www.knitt.co.kr/shopimages/knitt/0060000015423.jpg','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'오늘 저녁 뭐드셨나요?','저는 치킨을 먹었답니다 치킨은 역시 교촌이죠~ 어떤 치킨을 제일 좋아하시나요?','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'요즘 드라마 뭐보시나요ㅠ','저는 잼난게 없네요ㅋ','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'롱패딩 브랜드 추천받습니다!!!!!!!','롱패딩 없이 겨울 보내려다가 넘 추워서 걍 하나 살라고여ㅠ','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'신촌에 뜨개질 재료 파는 곳 있을까요?','ㅠ 뜨개질 재료사러 마땅히 갈데가 없네요...','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'코바늘,,, 너무 어렵네요','ㅈㄱㄴ','https://s3.ap-northeast-2.amazonaws.com/st.dangidata/hobby_conects/data/adm/lecture_manage/curriculum/9eb7dd4c09db3f875d2bdc0426dc0612.JPG','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'뜨개질 하는 밤,,','사실은 코딩하는 밤,,,','','s2',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'@@@@@햇살론 누구나 대출해드립니다@@@@@@','대출하실분 연락주세요 010-1221-122','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'저 광고 뭔가요 ㅡ ㅡ?','진짜 별루네요','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'마라탕 맛집 추천해주세요~','신촌은 천궁전이 맛있더라구요 ㅋ','','s2',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'다들 마스크 얼마나 쟁이세요?','저는 백장사뒀는데 ㅠ 더사야 할까요 ㅠ ','https://img.etoday.co.kr/pto_db/2020/06/600/20200604165949_1468710_1200_620.jpg','s2',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'자동차세 연납 오늘까지 10%할인되여~~','ㅈㄱㄴ','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (2,'내일 눈이 올까요','눈좀 그만왔으면 좋겠는데 ㅠ','','s4',0);


-- 공지게시판
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'광고글 작성시 탈퇴처리 안내문','광고글 쓰면 탈퇴시킵니다','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'코바늘 공구 열립니다','코바늘 공구 열립니다. 많은 참여 부탁드립니다','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'다가오는 봄을 위한 온라인 뜨개질 클래스 개설','온라인 뜨개질 클래스를 열었습니다 많은 참여 부탁드립니다','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'털실2차 공구 열립니다','다이소 털실 2차 공구 엽니다','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'요즘 운영자를 사칭하는 사건이 발생하고 있습니다.','뜨개질 커뮤니티 운영자는 쪽지로 회원에게 금품을 요구하지 않습니다.','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'모자 도안 공구합니다','많은 참여 부탁 드립니다','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'니트 도안 공구합니다','뽀로로니트 도안 공구합니다. 뽀로로 짱','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'털실공구합니다. 많은 참여 부탁드립니다','다이소 털실 공구합니다. 많이 신청해주세요','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'2월 5일 정모 열립니다','코로나라서 사실 안열어요','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (1,'뜨개질 커뮤니티에 오신것을 환영합니다','글하고 댓글 많이 써주세요','','s1',0);


-- 뜨개질 정보 공유
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'####귀도리 뜨개질####','귀도리 뜨개질','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'니트 도안 구매처 정보','니트 도안 구매처 정보','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'털실 구매처 정보','털실 구매처 정보','','s2',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'초급자를 위한 그물가방 짜기 강의','초급자를 위한 그물가방 짜기 강의','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'티코스터 만들기 강의','티코스터 만들기 강의','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'위빙 클래스 오픈','위빙 클래스 오픈','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'뜨개질 온라인 클래스 5','뜨개질 온라인 클래스 5','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'뜨개질 온라인 클래스 4','뜨개질 온라인 클래스 4','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'뜨개질 온라인 클래스 3','뜨개질 온라인 클래스 3','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'뜨개질 온라인 클래스 2','뜨개질 온라인 클래스 2','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'뜨개질 온라인 클래스 1','뜨개질 온라인 클래스 1','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'애기 니트뜨기 강의 @~!~','애기 니트 뜨기 강의','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'춘배 에어팟케이스 뜨기3','춘배 에어팟케이스 뜨기','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'아기 양말뜨기','아기 양말뜨기','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'*^^*겨울철 모자뜨기 ','','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'아가일 니트뜨기 (난이도 상)','어려워요 주의해서 떠야합니다','https://i.pinimg.com/originals/3b/9b/46/3b9b46629b5840b449da8d31792fce45.jpg','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'춘배 에어팟케이스 뜨기2','춘배 에어팟케이스 뜨기','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'겨울철 포근한 목도리 뜨기 정보 입니다','겨울철 포근한 목도리 뜨기','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'춘배 에어팟케이스 뜨기1','춘배 에어팟 케이스 뜨기','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (3,'뽀로로 모자뜨기에요^^','뽀로로 모자뜨기','','s1',0);

-- 중고거래
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'엽기토끼 스킬자수 판매합니다','오백원에 팝니다','','s2',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'신촌역 직거래 캐논60d 팝니다','상태양호합니다','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'베드 테이블 좀 사가세요~~~~~~~~~','ㅈㄱㄴ','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'@~ 아기 니트 팔아요 ~@','제가 직접 뜬 제품입니다','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'가방뜨기 인강 3달권 판매합니다','ㅈㄱㄴ','','s1',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'십자수로 갈아타서 털실 다 판매합니다','털실 다 팔아요','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'###털실 삽니다###','털실 삽니다','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'아이패드 에어3 판매합니다######','1년썻고 60에 팝니다','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'뜨개질 교본팔아요!!!!!!!!!','상태 깨끗합니다','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'뜨개질 교본팔아요!!!!!!!!!','상태 깨끗합니다','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'뜨개질 교본팔아요!!!!!!!!!','상태 깨끗합니다','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'뜨개질 교본팔아요!!!!!!!!!','상태 깨끗합니다','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'맥북m1미개봉상품 판매합니다 116-> 110','에눌안되요 직거래선호합니다','','s2',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'위빙틀 판매합니다','너무 어려워서 판매합니다 택배거래만 해요','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'뜨개질 교본 팔아요!!!!!!!','상태 깨끗합니다','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'미싱 판매합니다~~(직거래 선호','직거래만해요','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'@@책 팝니다@@','책사가세요','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'여름용 그물가방 팝니다','하나에 이만원이고 직접 제작한 상품입니다','','s5',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'###삽니다### 대바늘 10쌍 싸게 구해봅니다','ㅈㄱㄴ','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'독서실 책상 판매','산지 1년 됬는데 급처합니다 에누리 가능','','s3',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'@@@@@@@햇살론 무담보 무보증 대출@@@@@@','대출받으실 분들 연락미 010-3434-3434','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'겨울털실 세트 팔아요!~~~~!!!!!','하나에 오백원','','s2',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'위빙으로 제작한 카페트 팝니다','하나에 천만원입니다','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'제가 직접 짠 티코스터 팝니다','한장에 오백만원입니다','','s4',0);
INSERT INTO board(blno, title, contents, img, id, view_count) VALUES (4,'코바늘 2쌍 팝니다','한달된건데 탈뜨개질합니다','','s5',0);