package ${packageName};

<#if generateLayout>
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>
</#if>
import com.sch.nova.MvpFragment;

public class ${fragmentClass} extends MvpFragment<${viewClass}, ${presenterClass}> implements ${viewClass} {
<#if generateLayout>
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.${layoutName}, container, false);
    }
</#if>
    @Override
    public ${presenterClass} createPresenter() {
        return new ${presenterClass}();
    }
}
