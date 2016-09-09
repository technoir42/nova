<?xml version="1.0"?>
<recipe>

    <dependency mavenUrl="com.sch.nova:nova:1.0.0" />

<#if generateLayout>
    <instantiate from="root/res/layout/fragment_mvp.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />

    <open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
</#if>

    <instantiate from="root/src/app_package/MvpFragment.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${fragmentClass}.java" />

    <instantiate from="root/src/app_package/MvpView.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${viewClass}.java" />

    <instantiate from="root/src/app_package/MvpPresenter.java.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${presenterClass}.java" />

    <open file="${escapeXmlAttribute(srcOut)}/${fragmentClass}.java" />

</recipe>
