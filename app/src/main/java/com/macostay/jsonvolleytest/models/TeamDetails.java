package com.macostay.jsonvolleytest.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by macostay on 10/12/2015.
 */
public class TeamDetails implements Parcelable {

    private String id;
    private String nameShow;
    private String basealias;
    private String CountryCode;
    private String location;
    private String basename;
    private String stadium;
    private String short_name;
    private String managerNow;
    private String seats;
    private String website;
    private String yearFoundation;
    private String city;
    private String address;
    private String phone;
    private String fax;
    private String chairman;
    private String fullName;
    private String yearlyBudget;
    private String info;
    private String fans;
    private String typefield;
    private String ctype;
    private String yearBuilt;
    private String size;
    private String historical;
    private String comments;
    private String color1;
    private String color2;
    private String kit_home;
    private String kit_away;
    private String kit_third;
    private String twitter;
    private String twitter_coach;
    private String twitter_president;
    private String twitter_b;
    private String qod;
    private String pod;
    private String last_change;
    private String relations;
    private String relatedImg;
    private String basealias_old;
    private String patrocinador;
    private String patrocinador_b;
    private String team_b;
    private String proveedor;
    private String lugar_entrenamiento;
    private String repeat_year;
    private String no_year;
    private String error_date;
    private String fifaId;
    private String main_image;
    private String type_team;
    private String active_relations;
    private String match_played;
    private String match_to_play;
    private String localidad;
    private String geonameid;
    private String hid;
    private String hid_B;
    private String translate;
    private String email;
    private String Name;
    private String Continent;
    private String Region;
    private String shield;
    private String img_stadium;
    private PlayerTeamList squad;

    public TeamDetails() {
    }

    public TeamDetails(String id, String nameShow, String basealias, String countryCode, String location, String basename, String stadium, String short_name, String managerNow, String seats, String website, String yearFoundation, String city, String address, String phone, String fax, String chairman, String fullName, String yearlyBudget, String info, String fans, String typefield, String ctype, String yearBuilt, String size, String historical, String comments, String color1, String kit_home, String color2, String kit_away, String kit_third, String twitter, String twitter_coach, String twitter_president, String twitter_b, String qod, String pod, String last_change, String relations, String relatedImg, String basealias_old, String patrocinador, String patrocinador_b, String team_b, String proveedor, String lugar_entrenamiento, String repeat_year, String no_year, String error_date, String fifaId, String main_image, String type_team, String active_relations, String match_played, String match_to_play, String localidad, String geonameid, String hid, String hid_B, String translate, String email, String name, String continent, String region, String shield, String img_stadium, PlayerTeamList squad) {
        this.id = id;
        this.nameShow = nameShow;
        this.basealias = basealias;
        CountryCode = countryCode;
        this.location = location;
        this.basename = basename;
        this.stadium = stadium;
        this.short_name = short_name;
        this.managerNow = managerNow;
        this.seats = seats;
        this.website = website;
        this.yearFoundation = yearFoundation;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
        this.chairman = chairman;
        this.fullName = fullName;
        this.yearlyBudget = yearlyBudget;
        this.info = info;
        this.fans = fans;
        this.typefield = typefield;
        this.ctype = ctype;
        this.yearBuilt = yearBuilt;
        this.size = size;
        this.historical = historical;
        this.comments = comments;
        this.color1 = color1;
        this.kit_home = kit_home;
        this.color2 = color2;
        this.kit_away = kit_away;
        this.kit_third = kit_third;
        this.twitter = twitter;
        this.twitter_coach = twitter_coach;
        this.twitter_president = twitter_president;
        this.twitter_b = twitter_b;
        this.qod = qod;
        this.pod = pod;
        this.last_change = last_change;
        this.relations = relations;
        this.relatedImg = relatedImg;
        this.basealias_old = basealias_old;
        this.patrocinador = patrocinador;
        this.patrocinador_b = patrocinador_b;
        this.team_b = team_b;
        this.proveedor = proveedor;
        this.lugar_entrenamiento = lugar_entrenamiento;
        this.repeat_year = repeat_year;
        this.no_year = no_year;
        this.error_date = error_date;
        this.fifaId = fifaId;
        this.main_image = main_image;
        this.type_team = type_team;
        this.active_relations = active_relations;
        this.match_played = match_played;
        this.match_to_play = match_to_play;
        this.localidad = localidad;
        this.geonameid = geonameid;
        this.hid = hid;
        this.hid_B = hid_B;
        this.translate = translate;
        this.email = email;
        Name = name;
        Continent = continent;
        Region = region;
        this.shield = shield;
        this.img_stadium = img_stadium;
        this.squad = squad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameShow() {
        return nameShow;
    }

    public void setNameShow(String nameShow) {
        this.nameShow = nameShow;
    }

    public String getBasealias() {
        return basealias;
    }

    public void setBasealias(String basealias) {
        this.basealias = basealias;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBasename() {
        return basename;
    }

    public void setBasename(String basename) {
        this.basename = basename;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getManagerNow() {
        return managerNow;
    }

    public void setManagerNow(String managerNow) {
        this.managerNow = managerNow;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getYearFoundation() {
        return yearFoundation;
    }

    public void setYearFoundation(String yearFoundation) {
        this.yearFoundation = yearFoundation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getYearlyBudget() {
        return yearlyBudget;
    }

    public void setYearlyBudget(String yearlyBudget) {
        this.yearlyBudget = yearlyBudget;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTypefield() {
        return typefield;
    }

    public void setTypefield(String typefield) {
        this.typefield = typefield;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(String yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getHistorical() {
        return historical;
    }

    public void setHistorical(String historical) {
        this.historical = historical;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getKit_home() {
        return kit_home;
    }

    public void setKit_home(String kit_home) {
        this.kit_home = kit_home;
    }

    public String getKit_away() {
        return kit_away;
    }

    public void setKit_away(String kit_away) {
        this.kit_away = kit_away;
    }

    public String getKit_third() {
        return kit_third;
    }

    public void setKit_third(String kit_third) {
        this.kit_third = kit_third;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getTwitter_coach() {
        return twitter_coach;
    }

    public void setTwitter_coach(String twitter_coach) {
        this.twitter_coach = twitter_coach;
    }

    public String getTwitter_president() {
        return twitter_president;
    }

    public void setTwitter_president(String twitter_president) {
        this.twitter_president = twitter_president;
    }

    public String getTwitter_b() {
        return twitter_b;
    }

    public void setTwitter_b(String twitter_b) {
        this.twitter_b = twitter_b;
    }

    public String getQod() {
        return qod;
    }

    public void setQod(String qod) {
        this.qod = qod;
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }

    public String getLast_change() {
        return last_change;
    }

    public void setLast_change(String last_change) {
        this.last_change = last_change;
    }

    public String getRelations() {
        return relations;
    }

    public void setRelations(String relations) {
        this.relations = relations;
    }

    public String getRelatedImg() {
        return relatedImg;
    }

    public void setRelatedImg(String relatedImg) {
        this.relatedImg = relatedImg;
    }

    public String getBasealias_old() {
        return basealias_old;
    }

    public void setBasealias_old(String basealias_old) {
        this.basealias_old = basealias_old;
    }

    public String getPatrocinador() {
        return patrocinador;
    }

    public void setPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
    }

    public String getPatrocinador_b() {
        return patrocinador_b;
    }

    public void setPatrocinador_b(String patrocinador_b) {
        this.patrocinador_b = patrocinador_b;
    }

    public String getTeam_b() {
        return team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getLugar_entrenamiento() {
        return lugar_entrenamiento;
    }

    public void setLugar_entrenamiento(String lugar_entrenamiento) {
        this.lugar_entrenamiento = lugar_entrenamiento;
    }

    public String getRepeat_year() {
        return repeat_year;
    }

    public void setRepeat_year(String repeat_year) {
        this.repeat_year = repeat_year;
    }

    public String getNo_year() {
        return no_year;
    }

    public void setNo_year(String no_year) {
        this.no_year = no_year;
    }

    public String getError_date() {
        return error_date;
    }

    public void setError_date(String error_date) {
        this.error_date = error_date;
    }

    public String getFifaId() {
        return fifaId;
    }

    public void setFifaId(String fifaId) {
        this.fifaId = fifaId;
    }

    public String getMain_image() {
        return main_image;
    }

    public void setMain_image(String main_image) {
        this.main_image = main_image;
    }

    public String getType_team() {
        return type_team;
    }

    public void setType_team(String type_team) {
        this.type_team = type_team;
    }

    public String getActive_relations() {
        return active_relations;
    }

    public void setActive_relations(String active_relations) {
        this.active_relations = active_relations;
    }

    public String getMatch_played() {
        return match_played;
    }

    public void setMatch_played(String match_played) {
        this.match_played = match_played;
    }

    public String getMatch_to_play() {
        return match_to_play;
    }

    public void setMatch_to_play(String match_to_play) {
        this.match_to_play = match_to_play;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getGeonameid() {
        return geonameid;
    }

    public void setGeonameid(String geonameid) {
        this.geonameid = geonameid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getHid_B() {
        return hid_B;
    }

    public void setHid_B(String hid_B) {
        this.hid_B = hid_B;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String continent) {
        Continent = continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public String getImg_stadium() {
        return img_stadium;
    }

    public void setImg_stadium(String img_stadium) {
        this.img_stadium = img_stadium;
    }

    public PlayerTeamList getSquad() {
        return squad;
    }

    public void setSquad(PlayerTeamList squad) {
        this.squad = squad;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.nameShow);
        dest.writeString(this.basealias);
        dest.writeString(this.CountryCode);
        dest.writeString(this.location);
        dest.writeString(this.basename);
        dest.writeString(this.stadium);
        dest.writeString(this.short_name);
        dest.writeString(this.managerNow);
        dest.writeString(this.seats);
        dest.writeString(this.website);
        dest.writeString(this.yearFoundation);
        dest.writeString(this.city);
        dest.writeString(this.address);
        dest.writeString(this.phone);
        dest.writeString(this.fax);
        dest.writeString(this.chairman);
        dest.writeString(this.fullName);
        dest.writeString(this.yearlyBudget);
        dest.writeString(this.info);
        dest.writeString(this.fans);
        dest.writeString(this.typefield);
        dest.writeString(this.ctype);
        dest.writeString(this.yearBuilt);
        dest.writeString(this.size);
        dest.writeString(this.historical);
        dest.writeString(this.comments);
        dest.writeString(this.color1);
        dest.writeString(this.color2);
        dest.writeString(this.kit_home);
        dest.writeString(this.kit_away);
        dest.writeString(this.kit_third);
        dest.writeString(this.twitter);
        dest.writeString(this.twitter_coach);
        dest.writeString(this.twitter_president);
        dest.writeString(this.twitter_b);
        dest.writeString(this.qod);
        dest.writeString(this.pod);
        dest.writeString(this.last_change);
        dest.writeString(this.relations);
        dest.writeString(this.relatedImg);
        dest.writeString(this.basealias_old);
        dest.writeString(this.patrocinador);
        dest.writeString(this.patrocinador_b);
        dest.writeString(this.team_b);
        dest.writeString(this.proveedor);
        dest.writeString(this.lugar_entrenamiento);
        dest.writeString(this.repeat_year);
        dest.writeString(this.no_year);
        dest.writeString(this.error_date);
        dest.writeString(this.fifaId);
        dest.writeString(this.main_image);
        dest.writeString(this.type_team);
        dest.writeString(this.active_relations);
        dest.writeString(this.match_played);
        dest.writeString(this.match_to_play);
        dest.writeString(this.localidad);
        dest.writeString(this.geonameid);
        dest.writeString(this.hid);
        dest.writeString(this.hid_B);
        dest.writeString(this.translate);
        dest.writeString(this.email);
        dest.writeString(this.Name);
        dest.writeString(this.Continent);
        dest.writeString(this.Region);
        dest.writeString(this.shield);
        dest.writeString(this.img_stadium);
        dest.writeParcelable(this.squad, 0);
    }

    protected TeamDetails(Parcel in) {
        this.id = in.readString();
        this.nameShow = in.readString();
        this.basealias = in.readString();
        this.CountryCode = in.readString();
        this.location = in.readString();
        this.basename = in.readString();
        this.stadium = in.readString();
        this.short_name = in.readString();
        this.managerNow = in.readString();
        this.seats = in.readString();
        this.website = in.readString();
        this.yearFoundation = in.readString();
        this.city = in.readString();
        this.address = in.readString();
        this.phone = in.readString();
        this.fax = in.readString();
        this.chairman = in.readString();
        this.fullName = in.readString();
        this.yearlyBudget = in.readString();
        this.info = in.readString();
        this.fans = in.readString();
        this.typefield = in.readString();
        this.ctype = in.readString();
        this.yearBuilt = in.readString();
        this.size = in.readString();
        this.historical = in.readString();
        this.comments = in.readString();
        this.color1 = in.readString();
        this.color2 = in.readString();
        this.kit_home = in.readString();
        this.kit_away = in.readString();
        this.kit_third = in.readString();
        this.twitter = in.readString();
        this.twitter_coach = in.readString();
        this.twitter_president = in.readString();
        this.twitter_b = in.readString();
        this.qod = in.readString();
        this.pod = in.readString();
        this.last_change = in.readString();
        this.relations = in.readString();
        this.relatedImg = in.readString();
        this.basealias_old = in.readString();
        this.patrocinador = in.readString();
        this.patrocinador_b = in.readString();
        this.team_b = in.readString();
        this.proveedor = in.readString();
        this.lugar_entrenamiento = in.readString();
        this.repeat_year = in.readString();
        this.no_year = in.readString();
        this.error_date = in.readString();
        this.fifaId = in.readString();
        this.main_image = in.readString();
        this.type_team = in.readString();
        this.active_relations = in.readString();
        this.match_played = in.readString();
        this.match_to_play = in.readString();
        this.localidad = in.readString();
        this.geonameid = in.readString();
        this.hid = in.readString();
        this.hid_B = in.readString();
        this.translate = in.readString();
        this.email = in.readString();
        this.Name = in.readString();
        this.Continent = in.readString();
        this.Region = in.readString();
        this.shield = in.readString();
        this.img_stadium = in.readString();
        this.squad = in.readParcelable(PlayerTeamList.class.getClassLoader());
    }

    public static final Creator<TeamDetails> CREATOR = new Creator<TeamDetails>() {
        public TeamDetails createFromParcel(Parcel source) {
            return new TeamDetails(source);
        }

        public TeamDetails[] newArray(int size) {
            return new TeamDetails[size];
        }
    };
}
