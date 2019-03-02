package cn.leekoko.pojo;

import java.util.ArrayList;
import java.util.List;

public class LifegameTempplanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LifegameTempplanExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNull() {
            addCriterion("plan_name is null");
            return (Criteria) this;
        }

        public Criteria andPlanNameIsNotNull() {
            addCriterion("plan_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlanNameEqualTo(String value) {
            addCriterion("plan_name =", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotEqualTo(String value) {
            addCriterion("plan_name <>", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThan(String value) {
            addCriterion("plan_name >", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameGreaterThanOrEqualTo(String value) {
            addCriterion("plan_name >=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThan(String value) {
            addCriterion("plan_name <", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLessThanOrEqualTo(String value) {
            addCriterion("plan_name <=", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameLike(String value) {
            addCriterion("plan_name like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotLike(String value) {
            addCriterion("plan_name not like", value, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameIn(List<String> values) {
            addCriterion("plan_name in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotIn(List<String> values) {
            addCriterion("plan_name not in", values, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameBetween(String value1, String value2) {
            addCriterion("plan_name between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andPlanNameNotBetween(String value1, String value2) {
            addCriterion("plan_name not between", value1, value2, "planName");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(Integer value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(Integer value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(Integer value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(Integer value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Integer> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Integer> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(Integer value1, Integer value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("money not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andParentcodeIsNull() {
            addCriterion("parentCode is null");
            return (Criteria) this;
        }

        public Criteria andParentcodeIsNotNull() {
            addCriterion("parentCode is not null");
            return (Criteria) this;
        }

        public Criteria andParentcodeEqualTo(String value) {
            addCriterion("parentCode =", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotEqualTo(String value) {
            addCriterion("parentCode <>", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThan(String value) {
            addCriterion("parentCode >", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeGreaterThanOrEqualTo(String value) {
            addCriterion("parentCode >=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThan(String value) {
            addCriterion("parentCode <", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLessThanOrEqualTo(String value) {
            addCriterion("parentCode <=", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeLike(String value) {
            addCriterion("parentCode like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotLike(String value) {
            addCriterion("parentCode not like", value, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeIn(List<String> values) {
            addCriterion("parentCode in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotIn(List<String> values) {
            addCriterion("parentCode not in", values, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeBetween(String value1, String value2) {
            addCriterion("parentCode between", value1, value2, "parentcode");
            return (Criteria) this;
        }

        public Criteria andParentcodeNotBetween(String value1, String value2) {
            addCriterion("parentCode not between", value1, value2, "parentcode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeIsNull() {
            addCriterion("smallTypeCode is null");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeIsNotNull() {
            addCriterion("smallTypeCode is not null");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeEqualTo(String value) {
            addCriterion("smallTypeCode =", value, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeNotEqualTo(String value) {
            addCriterion("smallTypeCode <>", value, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeGreaterThan(String value) {
            addCriterion("smallTypeCode >", value, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("smallTypeCode >=", value, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeLessThan(String value) {
            addCriterion("smallTypeCode <", value, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeLessThanOrEqualTo(String value) {
            addCriterion("smallTypeCode <=", value, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeLike(String value) {
            addCriterion("smallTypeCode like", value, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeNotLike(String value) {
            addCriterion("smallTypeCode not like", value, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeIn(List<String> values) {
            addCriterion("smallTypeCode in", values, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeNotIn(List<String> values) {
            addCriterion("smallTypeCode not in", values, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeBetween(String value1, String value2) {
            addCriterion("smallTypeCode between", value1, value2, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andSmalltypecodeNotBetween(String value1, String value2) {
            addCriterion("smallTypeCode not between", value1, value2, "smalltypecode");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNull() {
            addCriterion("delFlag is null");
            return (Criteria) this;
        }

        public Criteria andDelflagIsNotNull() {
            addCriterion("delFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDelflagEqualTo(Integer value) {
            addCriterion("delFlag =", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotEqualTo(Integer value) {
            addCriterion("delFlag <>", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThan(Integer value) {
            addCriterion("delFlag >", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("delFlag >=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThan(Integer value) {
            addCriterion("delFlag <", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagLessThanOrEqualTo(Integer value) {
            addCriterion("delFlag <=", value, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagIn(List<Integer> values) {
            addCriterion("delFlag in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotIn(List<Integer> values) {
            addCriterion("delFlag not in", values, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagBetween(Integer value1, Integer value2) {
            addCriterion("delFlag between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andDelflagNotBetween(Integer value1, Integer value2) {
            addCriterion("delFlag not between", value1, value2, "delflag");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFinishIsNull() {
            addCriterion("finish is null");
            return (Criteria) this;
        }

        public Criteria andFinishIsNotNull() {
            addCriterion("finish is not null");
            return (Criteria) this;
        }

        public Criteria andFinishEqualTo(String value) {
            addCriterion("finish =", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotEqualTo(String value) {
            addCriterion("finish <>", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThan(String value) {
            addCriterion("finish >", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThanOrEqualTo(String value) {
            addCriterion("finish >=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThan(String value) {
            addCriterion("finish <", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThanOrEqualTo(String value) {
            addCriterion("finish <=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLike(String value) {
            addCriterion("finish like", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotLike(String value) {
            addCriterion("finish not like", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishIn(List<String> values) {
            addCriterion("finish in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotIn(List<String> values) {
            addCriterion("finish not in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishBetween(String value1, String value2) {
            addCriterion("finish between", value1, value2, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotBetween(String value1, String value2) {
            addCriterion("finish not between", value1, value2, "finish");
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

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(String value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(String value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(String value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(String value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(String value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(String value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLike(String value) {
            addCriterion("createDate like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotLike(String value) {
            addCriterion("createDate not like", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<String> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<String> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(String value1, String value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(String value1, String value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNull() {
            addCriterion("modifyDate is null");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNotNull() {
            addCriterion("modifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andModifydateEqualTo(String value) {
            addCriterion("modifyDate =", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotEqualTo(String value) {
            addCriterion("modifyDate <>", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThan(String value) {
            addCriterion("modifyDate >", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThanOrEqualTo(String value) {
            addCriterion("modifyDate >=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThan(String value) {
            addCriterion("modifyDate <", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThanOrEqualTo(String value) {
            addCriterion("modifyDate <=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLike(String value) {
            addCriterion("modifyDate like", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotLike(String value) {
            addCriterion("modifyDate not like", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateIn(List<String> values) {
            addCriterion("modifyDate in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotIn(List<String> values) {
            addCriterion("modifyDate not in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateBetween(String value1, String value2) {
            addCriterion("modifyDate between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotBetween(String value1, String value2) {
            addCriterion("modifyDate not between", value1, value2, "modifydate");
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