package mvp.gjj.gjj_mvp_basedemo.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2015/8/12.
 */
public class CoachBean implements Serializable {

    /**
     * summary : null
     * constellation : null
     * coaching_years : null
     * pictures : []
     * id : 18
     * slogan : null
     * invitationCode : 18#z1d
     * distance : 0
     * rank : 4
     * coaching_specialty :
     * ID_number : null
     * is_sign_agreement : false
     * name : null
     * creation_time : 2015-08-12T14:16:36.000+08:00
     * grade : null
     * gender : GENDER_OTHER
     * teaching_location : null
     * major : null
     * tags : null
     * sports_history : null
     * idCardpictures : []
     * coach_source : null
     * nickname : null
     * graduate_school : null
     * photo : http://api-img-1yd.qiniudn.com/coach-4f92f05c-e476-471d-929d-fe08f7c17ea0.jpg
     * is_full_time : null
     * invitation_code : 18#z1d
     * collectd_user : []
     * categories : []
     * audit_status : TO_CHECK
     * mobile : 18627607567
     * "user_id": 65620,
     "account_balance": 193400
     */
    public String summary;//描述
    public String constellation;
    public String coaching_years;//指教年限
    public List<My_photo_bean> pictures;
    public int id=-1;
    public String slogan;//口号
    public String invitationCode;
    public int distance;
    public int rank;
    public String coaching_specialty;//专长
    public String ID_number;//身份证
    public boolean is_sign_agreement;
    public String name;//姓名
    public String creation_time;
    public String grade;
    private int age=-1;//年龄
    public String gender;//性别
    public String teaching_location;//教学地点
    public String major;
    public String tags;
    public String sports_history;//运动历史
    public List<?> idCardpictures;
    public String coach_source;
    public String nickname;//昵称
    public String graduate_school;//毕业院校
    public String photo;//头像
    public String is_full_time;
    public String invitation_code;
    public List<?> collectd_user;
    public List<Category> categories;
    public String audit_status;
    public String mobile;//手机
    private int year_of_birth;//年龄
    private String myself_intro;//个人简介
    private String teach_testimonials;//执教宣言
    private String head_picture;//教练头像

    private int user_id=-1;
    private int account_balance=-1;

    /**
     * 添加错误信息de
     * @param user_id
     */
    public String errmsg;
    public String errcode;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getAccount_balance() {
        return account_balance;
    }

    public void setHead_picture(String head_picture) {
        this.head_picture = head_picture;
    }

    public String getHead_picture() {
        return head_picture;
    }

    public void setMyself_intro(String myself_intro) {
        this.myself_intro = myself_intro;
    }

    public void setTeach_testimonials(String teach_testimonials) {
        this.teach_testimonials = teach_testimonials;
    }

    public String getMyself_intro() {
        return myself_intro;
    }

    public String getTeach_testimonials() {
        return teach_testimonials;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public void setCoaching_years(String coaching_years) {
        this.coaching_years = coaching_years;
    }

    public void setPictures(List<My_photo_bean> pictures) {
        this.pictures = pictures;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setCoaching_specialty(String coaching_specialty) {
        this.coaching_specialty = coaching_specialty;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }

    public void setIs_sign_agreement(boolean is_sign_agreement) {
        this.is_sign_agreement = is_sign_agreement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreation_time(String creation_time) {
        this.creation_time = creation_time;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTeaching_location(String teaching_location) {
        this.teaching_location = teaching_location;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setSports_history(String sports_history) {
        this.sports_history = sports_history;
    }

    public void setIdCardpictures(List<?> idCardpictures) {
        this.idCardpictures = idCardpictures;
    }

    public void setCoach_source(String coach_source) {
        this.coach_source = coach_source;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setGraduate_school(String graduate_school) {
        this.graduate_school = graduate_school;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setIs_full_time(String is_full_time) {
        this.is_full_time = is_full_time;
    }

    public void setInvitation_code(String invitation_code) {
        this.invitation_code = invitation_code;
    }

    public void setCollectd_user(List<?> collectd_user) {
        this.collectd_user = collectd_user;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setAudit_status(String audit_status) {
        this.audit_status = audit_status;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSummary() {
        return summary;
    }

    public String getConstellation() {
        return constellation;
    }

    public String getCoaching_years() {
        return coaching_years;
    }

    public List<My_photo_bean> getPictures() {
        return pictures;
    }

    public int getId() {
        return id;
    }

    public String getSlogan() {
        return slogan;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public int getDistance() {
        return distance;
    }

    public int getRank() {
        return rank;
    }

    public String getCoaching_specialty() {
        return coaching_specialty;
    }

    public String getID_number() {
        return ID_number;
    }

    public boolean is_sign_agreement() {
        return is_sign_agreement;
    }

    public String getName() {
        return name;
    }

    public String getCreation_time() {
        return creation_time;
    }

    public String getGrade() {
        return grade;
    }

    public String getGender() {
        return gender;
    }

    public String getTeaching_location() {
        return teaching_location;
    }

    public String getMajor() {
        return major;
    }

    public String getTags() {
        return tags;
    }

    public String getSports_history() {
        return sports_history;
    }

    public List<?> getIdCardpictures() {
        return idCardpictures;
    }

    public String getCoach_source() {
        return coach_source;
    }

    public String getNickname() {
        return nickname;
    }

    public String getGraduate_school() {
        return graduate_school;
    }

    public String getPhoto() {
        return photo;
    }

    public String getIs_full_time() {
        return is_full_time;
    }

    public String getInvitation_code() {
        return invitation_code;
    }

    public List<?> getCollectd_user() {
        return collectd_user;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getAudit_status() {
        return audit_status;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "CoachBean{" +
                "summary='" + summary + '\'' +
                ", constellation='" + constellation + '\'' +
                ", coaching_years='" + coaching_years + '\'' +
                ", pictures=" + pictures +
                ", id=" + id +
                ", slogan='" + slogan + '\'' +
                ", invitationCode='" + invitationCode + '\'' +
                ", distance=" + distance +
                ", rank=" + rank +
                ", coaching_specialty='" + coaching_specialty + '\'' +
                ", ID_number='" + ID_number + '\'' +
                ", is_sign_agreement=" + is_sign_agreement +
                ", name='" + name + '\'' +
                ", creation_time='" + creation_time + '\'' +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", teaching_location='" + teaching_location + '\'' +
                ", major='" + major + '\'' +
                ", tags='" + tags + '\'' +
                ", sports_history='" + sports_history + '\'' +
                ", idCardpictures=" + idCardpictures +
                ", coach_source='" + coach_source + '\'' +
                ", nickname='" + nickname + '\'' +
                ", graduate_school='" + graduate_school + '\'' +
                ", photo='" + photo + '\'' +
                ", is_full_time='" + is_full_time + '\'' +
                ", invitation_code='" + invitation_code + '\'' +
                ", collectd_user=" + collectd_user +
                ", categories=" + categories +
                ", audit_status='" + audit_status + '\'' +
                ", mobile='" + mobile + '\'' +
                ", year_of_birth=" + year_of_birth +
                ", myself_intro='" + myself_intro + '\'' +
                ", teach_testimonials='" + teach_testimonials + '\'' +
                ", head_picture='" + head_picture + '\'' +
                ", user_id=" + user_id +
                ", account_balance=" + account_balance +
                ", errmsg='" + errmsg + '\'' +
                ", errcode='" + errcode + '\'' +
                '}';
    }
}
