package cn.leekoko.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibraryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LibraryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSeatnumIsNull() {
            addCriterion("seatnum is null");
            return (Criteria) this;
        }

        public Criteria andSeatnumIsNotNull() {
            addCriterion("seatnum is not null");
            return (Criteria) this;
        }

        public Criteria andSeatnumEqualTo(String value) {
            addCriterion("seatnum =", value, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumNotEqualTo(String value) {
            addCriterion("seatnum <>", value, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumGreaterThan(String value) {
            addCriterion("seatnum >", value, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumGreaterThanOrEqualTo(String value) {
            addCriterion("seatnum >=", value, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumLessThan(String value) {
            addCriterion("seatnum <", value, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumLessThanOrEqualTo(String value) {
            addCriterion("seatnum <=", value, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumLike(String value) {
            addCriterion("seatnum like", value, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumNotLike(String value) {
            addCriterion("seatnum not like", value, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumIn(List<String> values) {
            addCriterion("seatnum in", values, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumNotIn(List<String> values) {
            addCriterion("seatnum not in", values, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumBetween(String value1, String value2) {
            addCriterion("seatnum between", value1, value2, "seatnum");
            return (Criteria) this;
        }

        public Criteria andSeatnumNotBetween(String value1, String value2) {
            addCriterion("seatnum not between", value1, value2, "seatnum");
            return (Criteria) this;
        }

        public Criteria andCurrentuserIsNull() {
            addCriterion("currentUser is null");
            return (Criteria) this;
        }

        public Criteria andCurrentuserIsNotNull() {
            addCriterion("currentUser is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentuserEqualTo(String value) {
            addCriterion("currentUser =", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserNotEqualTo(String value) {
            addCriterion("currentUser <>", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserGreaterThan(String value) {
            addCriterion("currentUser >", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserGreaterThanOrEqualTo(String value) {
            addCriterion("currentUser >=", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserLessThan(String value) {
            addCriterion("currentUser <", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserLessThanOrEqualTo(String value) {
            addCriterion("currentUser <=", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserLike(String value) {
            addCriterion("currentUser like", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserNotLike(String value) {
            addCriterion("currentUser not like", value, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserIn(List<String> values) {
            addCriterion("currentUser in", values, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserNotIn(List<String> values) {
            addCriterion("currentUser not in", values, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserBetween(String value1, String value2) {
            addCriterion("currentUser between", value1, value2, "currentuser");
            return (Criteria) this;
        }

        public Criteria andCurrentuserNotBetween(String value1, String value2) {
            addCriterion("currentUser not between", value1, value2, "currentuser");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNull() {
            addCriterion("delflag is null");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNotNull() {
            addCriterion("delflag is not null");
            return (Criteria) this;
        }

        public Criteria andDelflagEqualTo(Integer value) {
            addCriterion("delflag =", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotEqualTo(Integer value) {
            addCriterion("delflag <>", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThan(Integer value) {
            addCriterion("delflag >", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delflag >=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThan(Integer value) {
            addCriterion("delflag <", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThanOrEqualTo(Integer value) {
            addCriterion("delflag <=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagIn(List<Integer> values) {
            addCriterion("delflag in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotIn(List<Integer> values) {
            addCriterion("delflag not in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagBetween(Integer value1, Integer value2) {
            addCriterion("delflag between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotBetween(Integer value1, Integer value2) {
            addCriterion("delflag not between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagIsNull() {
            addCriterion("currflag is null");
            return (Criteria) this;
        }

        public Criteria andCurrflagIsNotNull() {
            addCriterion("currflag is not null");
            return (Criteria) this;
        }

        public Criteria andCurrflagEqualTo(Integer value) {
            addCriterion("currflag =", value, "currflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagNotEqualTo(Integer value) {
            addCriterion("currflag <>", value, "currflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagGreaterThan(Integer value) {
            addCriterion("currflag >", value, "currflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("currflag >=", value, "currflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagLessThan(Integer value) {
            addCriterion("currflag <", value, "currflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagLessThanOrEqualTo(Integer value) {
            addCriterion("currflag <=", value, "currflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagIn(List<Integer> values) {
            addCriterion("currflag in", values, "currflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagNotIn(List<Integer> values) {
            addCriterion("currflag not in", values, "currflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagBetween(Integer value1, Integer value2) {
            addCriterion("currflag between", value1, value2, "currflag");
            return (Criteria) this;
        }

        public Criteria andCurrflagNotBetween(Integer value1, Integer value2) {
            addCriterion("currflag not between", value1, value2, "currflag");
            return (Criteria) this;
        }

        public Criteria andSittimeIsNull() {
            addCriterion("sitTime is null");
            return (Criteria) this;
        }

        public Criteria andSittimeIsNotNull() {
            addCriterion("sitTime is not null");
            return (Criteria) this;
        }

        public Criteria andSittimeEqualTo(Date value) {
            addCriterion("sitTime =", value, "sittime");
            return (Criteria) this;
        }

        public Criteria andSittimeNotEqualTo(Date value) {
            addCriterion("sitTime <>", value, "sittime");
            return (Criteria) this;
        }

        public Criteria andSittimeGreaterThan(Date value) {
            addCriterion("sitTime >", value, "sittime");
            return (Criteria) this;
        }

        public Criteria andSittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sitTime >=", value, "sittime");
            return (Criteria) this;
        }

        public Criteria andSittimeLessThan(Date value) {
            addCriterion("sitTime <", value, "sittime");
            return (Criteria) this;
        }

        public Criteria andSittimeLessThanOrEqualTo(Date value) {
            addCriterion("sitTime <=", value, "sittime");
            return (Criteria) this;
        }

        public Criteria andSittimeIn(List<Date> values) {
            addCriterion("sitTime in", values, "sittime");
            return (Criteria) this;
        }

        public Criteria andSittimeNotIn(List<Date> values) {
            addCriterion("sitTime not in", values, "sittime");
            return (Criteria) this;
        }

        public Criteria andSittimeBetween(Date value1, Date value2) {
            addCriterion("sitTime between", value1, value2, "sittime");
            return (Criteria) this;
        }

        public Criteria andSittimeNotBetween(Date value1, Date value2) {
            addCriterion("sitTime not between", value1, value2, "sittime");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaIsNull() {
            addCriterion("letOutTimeA is null");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaIsNotNull() {
            addCriterion("letOutTimeA is not null");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaEqualTo(Date value) {
            addCriterion("letOutTimeA =", value, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaNotEqualTo(Date value) {
            addCriterion("letOutTimeA <>", value, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaGreaterThan(Date value) {
            addCriterion("letOutTimeA >", value, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaGreaterThanOrEqualTo(Date value) {
            addCriterion("letOutTimeA >=", value, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaLessThan(Date value) {
            addCriterion("letOutTimeA <", value, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaLessThanOrEqualTo(Date value) {
            addCriterion("letOutTimeA <=", value, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaIn(List<Date> values) {
            addCriterion("letOutTimeA in", values, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaNotIn(List<Date> values) {
            addCriterion("letOutTimeA not in", values, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaBetween(Date value1, Date value2) {
            addCriterion("letOutTimeA between", value1, value2, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimeaNotBetween(Date value1, Date value2) {
            addCriterion("letOutTimeA not between", value1, value2, "letouttimea");
            return (Criteria) this;
        }

        public Criteria andLetouttimebIsNull() {
            addCriterion("letOutTimeB is null");
            return (Criteria) this;
        }

        public Criteria andLetouttimebIsNotNull() {
            addCriterion("letOutTimeB is not null");
            return (Criteria) this;
        }

        public Criteria andLetouttimebEqualTo(Date value) {
            addCriterion("letOutTimeB =", value, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andLetouttimebNotEqualTo(Date value) {
            addCriterion("letOutTimeB <>", value, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andLetouttimebGreaterThan(Date value) {
            addCriterion("letOutTimeB >", value, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andLetouttimebGreaterThanOrEqualTo(Date value) {
            addCriterion("letOutTimeB >=", value, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andLetouttimebLessThan(Date value) {
            addCriterion("letOutTimeB <", value, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andLetouttimebLessThanOrEqualTo(Date value) {
            addCriterion("letOutTimeB <=", value, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andLetouttimebIn(List<Date> values) {
            addCriterion("letOutTimeB in", values, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andLetouttimebNotIn(List<Date> values) {
            addCriterion("letOutTimeB not in", values, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andLetouttimebBetween(Date value1, Date value2) {
            addCriterion("letOutTimeB between", value1, value2, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andLetouttimebNotBetween(Date value1, Date value2) {
            addCriterion("letOutTimeB not between", value1, value2, "letouttimeb");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(String value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(String value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(String value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(String value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(String value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(String value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLike(String value) {
            addCriterion("floor like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotLike(String value) {
            addCriterion("floor not like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<String> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<String> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(String value1, String value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(String value1, String value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andTsm1IsNull() {
            addCriterion("tsm1 is null");
            return (Criteria) this;
        }

        public Criteria andTsm1IsNotNull() {
            addCriterion("tsm1 is not null");
            return (Criteria) this;
        }

        public Criteria andTsm1EqualTo(String value) {
            addCriterion("tsm1 =", value, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1NotEqualTo(String value) {
            addCriterion("tsm1 <>", value, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1GreaterThan(String value) {
            addCriterion("tsm1 >", value, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1GreaterThanOrEqualTo(String value) {
            addCriterion("tsm1 >=", value, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1LessThan(String value) {
            addCriterion("tsm1 <", value, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1LessThanOrEqualTo(String value) {
            addCriterion("tsm1 <=", value, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1Like(String value) {
            addCriterion("tsm1 like", value, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1NotLike(String value) {
            addCriterion("tsm1 not like", value, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1In(List<String> values) {
            addCriterion("tsm1 in", values, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1NotIn(List<String> values) {
            addCriterion("tsm1 not in", values, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1Between(String value1, String value2) {
            addCriterion("tsm1 between", value1, value2, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm1NotBetween(String value1, String value2) {
            addCriterion("tsm1 not between", value1, value2, "tsm1");
            return (Criteria) this;
        }

        public Criteria andTsm2IsNull() {
            addCriterion("tsm2 is null");
            return (Criteria) this;
        }

        public Criteria andTsm2IsNotNull() {
            addCriterion("tsm2 is not null");
            return (Criteria) this;
        }

        public Criteria andTsm2EqualTo(String value) {
            addCriterion("tsm2 =", value, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2NotEqualTo(String value) {
            addCriterion("tsm2 <>", value, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2GreaterThan(String value) {
            addCriterion("tsm2 >", value, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2GreaterThanOrEqualTo(String value) {
            addCriterion("tsm2 >=", value, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2LessThan(String value) {
            addCriterion("tsm2 <", value, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2LessThanOrEqualTo(String value) {
            addCriterion("tsm2 <=", value, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2Like(String value) {
            addCriterion("tsm2 like", value, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2NotLike(String value) {
            addCriterion("tsm2 not like", value, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2In(List<String> values) {
            addCriterion("tsm2 in", values, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2NotIn(List<String> values) {
            addCriterion("tsm2 not in", values, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2Between(String value1, String value2) {
            addCriterion("tsm2 between", value1, value2, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm2NotBetween(String value1, String value2) {
            addCriterion("tsm2 not between", value1, value2, "tsm2");
            return (Criteria) this;
        }

        public Criteria andTsm3IsNull() {
            addCriterion("tsm3 is null");
            return (Criteria) this;
        }

        public Criteria andTsm3IsNotNull() {
            addCriterion("tsm3 is not null");
            return (Criteria) this;
        }

        public Criteria andTsm3EqualTo(String value) {
            addCriterion("tsm3 =", value, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3NotEqualTo(String value) {
            addCriterion("tsm3 <>", value, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3GreaterThan(String value) {
            addCriterion("tsm3 >", value, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3GreaterThanOrEqualTo(String value) {
            addCriterion("tsm3 >=", value, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3LessThan(String value) {
            addCriterion("tsm3 <", value, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3LessThanOrEqualTo(String value) {
            addCriterion("tsm3 <=", value, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3Like(String value) {
            addCriterion("tsm3 like", value, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3NotLike(String value) {
            addCriterion("tsm3 not like", value, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3In(List<String> values) {
            addCriterion("tsm3 in", values, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3NotIn(List<String> values) {
            addCriterion("tsm3 not in", values, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3Between(String value1, String value2) {
            addCriterion("tsm3 between", value1, value2, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm3NotBetween(String value1, String value2) {
            addCriterion("tsm3 not between", value1, value2, "tsm3");
            return (Criteria) this;
        }

        public Criteria andTsm4IsNull() {
            addCriterion("tsm4 is null");
            return (Criteria) this;
        }

        public Criteria andTsm4IsNotNull() {
            addCriterion("tsm4 is not null");
            return (Criteria) this;
        }

        public Criteria andTsm4EqualTo(String value) {
            addCriterion("tsm4 =", value, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4NotEqualTo(String value) {
            addCriterion("tsm4 <>", value, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4GreaterThan(String value) {
            addCriterion("tsm4 >", value, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4GreaterThanOrEqualTo(String value) {
            addCriterion("tsm4 >=", value, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4LessThan(String value) {
            addCriterion("tsm4 <", value, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4LessThanOrEqualTo(String value) {
            addCriterion("tsm4 <=", value, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4Like(String value) {
            addCriterion("tsm4 like", value, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4NotLike(String value) {
            addCriterion("tsm4 not like", value, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4In(List<String> values) {
            addCriterion("tsm4 in", values, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4NotIn(List<String> values) {
            addCriterion("tsm4 not in", values, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4Between(String value1, String value2) {
            addCriterion("tsm4 between", value1, value2, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm4NotBetween(String value1, String value2) {
            addCriterion("tsm4 not between", value1, value2, "tsm4");
            return (Criteria) this;
        }

        public Criteria andTsm5IsNull() {
            addCriterion("tsm5 is null");
            return (Criteria) this;
        }

        public Criteria andTsm5IsNotNull() {
            addCriterion("tsm5 is not null");
            return (Criteria) this;
        }

        public Criteria andTsm5EqualTo(String value) {
            addCriterion("tsm5 =", value, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5NotEqualTo(String value) {
            addCriterion("tsm5 <>", value, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5GreaterThan(String value) {
            addCriterion("tsm5 >", value, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5GreaterThanOrEqualTo(String value) {
            addCriterion("tsm5 >=", value, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5LessThan(String value) {
            addCriterion("tsm5 <", value, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5LessThanOrEqualTo(String value) {
            addCriterion("tsm5 <=", value, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5Like(String value) {
            addCriterion("tsm5 like", value, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5NotLike(String value) {
            addCriterion("tsm5 not like", value, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5In(List<String> values) {
            addCriterion("tsm5 in", values, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5NotIn(List<String> values) {
            addCriterion("tsm5 not in", values, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5Between(String value1, String value2) {
            addCriterion("tsm5 between", value1, value2, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm5NotBetween(String value1, String value2) {
            addCriterion("tsm5 not between", value1, value2, "tsm5");
            return (Criteria) this;
        }

        public Criteria andTsm6IsNull() {
            addCriterion("tsm6 is null");
            return (Criteria) this;
        }

        public Criteria andTsm6IsNotNull() {
            addCriterion("tsm6 is not null");
            return (Criteria) this;
        }

        public Criteria andTsm6EqualTo(String value) {
            addCriterion("tsm6 =", value, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6NotEqualTo(String value) {
            addCriterion("tsm6 <>", value, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6GreaterThan(String value) {
            addCriterion("tsm6 >", value, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6GreaterThanOrEqualTo(String value) {
            addCriterion("tsm6 >=", value, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6LessThan(String value) {
            addCriterion("tsm6 <", value, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6LessThanOrEqualTo(String value) {
            addCriterion("tsm6 <=", value, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6Like(String value) {
            addCriterion("tsm6 like", value, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6NotLike(String value) {
            addCriterion("tsm6 not like", value, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6In(List<String> values) {
            addCriterion("tsm6 in", values, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6NotIn(List<String> values) {
            addCriterion("tsm6 not in", values, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6Between(String value1, String value2) {
            addCriterion("tsm6 between", value1, value2, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm6NotBetween(String value1, String value2) {
            addCriterion("tsm6 not between", value1, value2, "tsm6");
            return (Criteria) this;
        }

        public Criteria andTsm7IsNull() {
            addCriterion("tsm7 is null");
            return (Criteria) this;
        }

        public Criteria andTsm7IsNotNull() {
            addCriterion("tsm7 is not null");
            return (Criteria) this;
        }

        public Criteria andTsm7EqualTo(String value) {
            addCriterion("tsm7 =", value, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7NotEqualTo(String value) {
            addCriterion("tsm7 <>", value, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7GreaterThan(String value) {
            addCriterion("tsm7 >", value, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7GreaterThanOrEqualTo(String value) {
            addCriterion("tsm7 >=", value, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7LessThan(String value) {
            addCriterion("tsm7 <", value, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7LessThanOrEqualTo(String value) {
            addCriterion("tsm7 <=", value, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7Like(String value) {
            addCriterion("tsm7 like", value, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7NotLike(String value) {
            addCriterion("tsm7 not like", value, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7In(List<String> values) {
            addCriterion("tsm7 in", values, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7NotIn(List<String> values) {
            addCriterion("tsm7 not in", values, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7Between(String value1, String value2) {
            addCriterion("tsm7 between", value1, value2, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm7NotBetween(String value1, String value2) {
            addCriterion("tsm7 not between", value1, value2, "tsm7");
            return (Criteria) this;
        }

        public Criteria andTsm8IsNull() {
            addCriterion("tsm8 is null");
            return (Criteria) this;
        }

        public Criteria andTsm8IsNotNull() {
            addCriterion("tsm8 is not null");
            return (Criteria) this;
        }

        public Criteria andTsm8EqualTo(String value) {
            addCriterion("tsm8 =", value, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8NotEqualTo(String value) {
            addCriterion("tsm8 <>", value, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8GreaterThan(String value) {
            addCriterion("tsm8 >", value, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8GreaterThanOrEqualTo(String value) {
            addCriterion("tsm8 >=", value, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8LessThan(String value) {
            addCriterion("tsm8 <", value, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8LessThanOrEqualTo(String value) {
            addCriterion("tsm8 <=", value, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8Like(String value) {
            addCriterion("tsm8 like", value, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8NotLike(String value) {
            addCriterion("tsm8 not like", value, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8In(List<String> values) {
            addCriterion("tsm8 in", values, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8NotIn(List<String> values) {
            addCriterion("tsm8 not in", values, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8Between(String value1, String value2) {
            addCriterion("tsm8 between", value1, value2, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm8NotBetween(String value1, String value2) {
            addCriterion("tsm8 not between", value1, value2, "tsm8");
            return (Criteria) this;
        }

        public Criteria andTsm9IsNull() {
            addCriterion("tsm9 is null");
            return (Criteria) this;
        }

        public Criteria andTsm9IsNotNull() {
            addCriterion("tsm9 is not null");
            return (Criteria) this;
        }

        public Criteria andTsm9EqualTo(String value) {
            addCriterion("tsm9 =", value, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9NotEqualTo(String value) {
            addCriterion("tsm9 <>", value, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9GreaterThan(String value) {
            addCriterion("tsm9 >", value, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9GreaterThanOrEqualTo(String value) {
            addCriterion("tsm9 >=", value, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9LessThan(String value) {
            addCriterion("tsm9 <", value, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9LessThanOrEqualTo(String value) {
            addCriterion("tsm9 <=", value, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9Like(String value) {
            addCriterion("tsm9 like", value, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9NotLike(String value) {
            addCriterion("tsm9 not like", value, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9In(List<String> values) {
            addCriterion("tsm9 in", values, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9NotIn(List<String> values) {
            addCriterion("tsm9 not in", values, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9Between(String value1, String value2) {
            addCriterion("tsm9 between", value1, value2, "tsm9");
            return (Criteria) this;
        }

        public Criteria andTsm9NotBetween(String value1, String value2) {
            addCriterion("tsm9 not between", value1, value2, "tsm9");
            return (Criteria) this;
        }

        public Criteria andLetouttypeIsNull() {
            addCriterion("letOutType is null");
            return (Criteria) this;
        }

        public Criteria andLetouttypeIsNotNull() {
            addCriterion("letOutType is not null");
            return (Criteria) this;
        }

        public Criteria andLetouttypeEqualTo(String value) {
            addCriterion("letOutType =", value, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeNotEqualTo(String value) {
            addCriterion("letOutType <>", value, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeGreaterThan(String value) {
            addCriterion("letOutType >", value, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeGreaterThanOrEqualTo(String value) {
            addCriterion("letOutType >=", value, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeLessThan(String value) {
            addCriterion("letOutType <", value, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeLessThanOrEqualTo(String value) {
            addCriterion("letOutType <=", value, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeLike(String value) {
            addCriterion("letOutType like", value, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeNotLike(String value) {
            addCriterion("letOutType not like", value, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeIn(List<String> values) {
            addCriterion("letOutType in", values, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeNotIn(List<String> values) {
            addCriterion("letOutType not in", values, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeBetween(String value1, String value2) {
            addCriterion("letOutType between", value1, value2, "letouttype");
            return (Criteria) this;
        }

        public Criteria andLetouttypeNotBetween(String value1, String value2) {
            addCriterion("letOutType not between", value1, value2, "letouttype");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}