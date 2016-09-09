package ${packageName};

<#if generateLayout>
import android.os.Bundle;
import android.support.annotation.Nullable;
<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>
</#if>
import com.sch.nova.MvpActivity;

public class ${activityClass} extends MvpActivity<${viewClass}, ${presenterClass}> implements ${viewClass} {
<#if generateLayout>
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.${layoutName});
    }
</#if>
    @Override
    public ${presenterClass} createPresenter() {
        return new ${presenterClass}();
    }
}
