// Generated by Dagger (https://dagger.dev).
package com.abdull.newsapp.application;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.abdull.newsapp.datasource.local.ArticleDao;
import com.abdull.newsapp.datasource.local.ArticleDatabase;
import com.abdull.newsapp.datasource.remote.NewsApi;
import com.abdull.newsapp.di.AppModule;
import com.abdull.newsapp.di.AppModule_ProvideArticleDaoFactory;
import com.abdull.newsapp.di.AppModule_ProvideNewsApiFactory;
import com.abdull.newsapp.di.AppModule_ProvideNewsDatabaseFactory;
import com.abdull.newsapp.di.AppModule_ProvideNewsRepositoryFactory;
import com.abdull.newsapp.di.AppModule_ProvideOkHttpClientFactory;
import com.abdull.newsapp.di.AppModule_ProvideRetrofitFactory;
import com.abdull.newsapp.repository.abstraction.NewsRepository;
import com.abdull.newsapp.ui.MainActivity;
import com.abdull.newsapp.ui.NewsViewModel;
import com.abdull.newsapp.ui.NewsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.abdull.newsapp.ui.fragments.NewsDetailsFragment;
import com.abdull.newsapp.ui.fragments.NewsFragment;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MemoizedSentinel;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerNewsApplication_HiltComponents_SingletonC extends NewsApplication_HiltComponents.SingletonC {
  private final ApplicationContextModule applicationContextModule;

  private final DaggerNewsApplication_HiltComponents_SingletonC singletonC = this;

  private volatile Object articleDatabase = new MemoizedSentinel();

  private volatile Object articleDao = new MemoizedSentinel();

  private volatile Object okHttpClient = new MemoizedSentinel();

  private volatile Object retrofit = new MemoizedSentinel();

  private volatile Object newsApi = new MemoizedSentinel();

  private volatile Object newsRepository = new MemoizedSentinel();

  private DaggerNewsApplication_HiltComponents_SingletonC(
      ApplicationContextModule applicationContextModuleParam) {
    this.applicationContextModule = applicationContextModuleParam;
  }

  public static Builder builder() {
    return new Builder();
  }

  private ArticleDatabase articleDatabase() {
    Object local = articleDatabase;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = articleDatabase;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideNewsDatabaseFactory.provideNewsDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
          articleDatabase = DoubleCheck.reentrantCheck(articleDatabase, local);
        }
      }
    }
    return (ArticleDatabase) local;
  }

  private ArticleDao articleDao() {
    Object local = articleDao;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = articleDao;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideArticleDaoFactory.provideArticleDao(articleDatabase());
          articleDao = DoubleCheck.reentrantCheck(articleDao, local);
        }
      }
    }
    return (ArticleDao) local;
  }

  private OkHttpClient okHttpClient() {
    Object local = okHttpClient;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = okHttpClient;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideOkHttpClientFactory.provideOkHttpClient();
          okHttpClient = DoubleCheck.reentrantCheck(okHttpClient, local);
        }
      }
    }
    return (OkHttpClient) local;
  }

  private Retrofit retrofit() {
    Object local = retrofit;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = retrofit;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideRetrofitFactory.provideRetrofit(okHttpClient());
          retrofit = DoubleCheck.reentrantCheck(retrofit, local);
        }
      }
    }
    return (Retrofit) local;
  }

  private NewsApi newsApi() {
    Object local = newsApi;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = newsApi;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideNewsApiFactory.provideNewsApi(retrofit());
          newsApi = DoubleCheck.reentrantCheck(newsApi, local);
        }
      }
    }
    return (NewsApi) local;
  }

  private NewsRepository newsRepository() {
    Object local = newsRepository;
    if (local instanceof MemoizedSentinel) {
      synchronized (local) {
        local = newsRepository;
        if (local instanceof MemoizedSentinel) {
          local = AppModule_ProvideNewsRepositoryFactory.provideNewsRepository(articleDao(), newsApi());
          newsRepository = DoubleCheck.reentrantCheck(newsRepository, local);
        }
      }
    }
    return (NewsRepository) local;
  }

  @Override
  public void injectNewsApplication(NewsApplication newsApplication) {
  }

  @Override
  public ActivityRetainedComponentBuilder retainedComponentBuilder() {
    return new ActivityRetainedCBuilder(singletonC);
  }

  @Override
  public ServiceComponentBuilder serviceComponentBuilder() {
    return new ServiceCBuilder(singletonC);
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public NewsApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new DaggerNewsApplication_HiltComponents_SingletonC(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements NewsApplication_HiltComponents.ActivityRetainedC.Builder {
    private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

    private ActivityRetainedCBuilder(DaggerNewsApplication_HiltComponents_SingletonC singletonC) {
      this.singletonC = singletonC;
    }

    @Override
    public NewsApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonC);
    }
  }

  private static final class ActivityRetainedCImpl extends NewsApplication_HiltComponents.ActivityRetainedC {
    private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private volatile Object lifecycle = new MemoizedSentinel();

    private ActivityRetainedCImpl(DaggerNewsApplication_HiltComponents_SingletonC singletonC) {
      this.singletonC = singletonC;

    }

    private Object lifecycle() {
      Object local = lifecycle;
      if (local instanceof MemoizedSentinel) {
        synchronized (local) {
          local = lifecycle;
          if (local instanceof MemoizedSentinel) {
            local = ActivityRetainedComponentManager_Lifecycle_Factory.newInstance();
            lifecycle = DoubleCheck.reentrantCheck(lifecycle, local);
          }
        }
      }
      return (Object) local;
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonC, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return (ActivityRetainedLifecycle) lifecycle();
    }

    private static final class ActivityCBuilder implements NewsApplication_HiltComponents.ActivityC.Builder {
      private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private Activity activity;

      private ActivityCBuilder(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
          ActivityRetainedCImpl activityRetainedCImpl) {
        this.singletonC = singletonC;
        this.activityRetainedCImpl = activityRetainedCImpl;
      }

      @Override
      public ActivityCBuilder activity(Activity activity) {
        this.activity = Preconditions.checkNotNull(activity);
        return this;
      }

      @Override
      public NewsApplication_HiltComponents.ActivityC build() {
        Preconditions.checkBuilderRequirement(activity, Activity.class);
        return new ActivityCImpl(singletonC, activityRetainedCImpl, activity);
      }
    }

    private static final class ActivityCImpl extends NewsApplication_HiltComponents.ActivityC {
      private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ActivityCImpl activityCImpl = this;

      private ActivityCImpl(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
          ActivityRetainedCImpl activityRetainedCImpl, Activity activity) {
        this.singletonC = singletonC;
        this.activityRetainedCImpl = activityRetainedCImpl;

      }

      @Override
      public void injectMainActivity(MainActivity mainActivity) {
      }

      @Override
      public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
        return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(ApplicationContextModule_ProvideApplicationFactory.provideApplication(singletonC.applicationContextModule), getViewModelKeys(), new ViewModelCBuilder(singletonC, activityRetainedCImpl));
      }

      @Override
      public Set<String> getViewModelKeys() {
        return Collections.<String>singleton(NewsViewModel_HiltModules_KeyModule_ProvideFactory.provide());
      }

      @Override
      public ViewModelComponentBuilder getViewModelComponentBuilder() {
        return new ViewModelCBuilder(singletonC, activityRetainedCImpl);
      }

      @Override
      public FragmentComponentBuilder fragmentComponentBuilder() {
        return new FragmentCBuilder(singletonC, activityRetainedCImpl, activityCImpl);
      }

      @Override
      public ViewComponentBuilder viewComponentBuilder() {
        return new ViewCBuilder(singletonC, activityRetainedCImpl, activityCImpl);
      }

      private static final class FragmentCBuilder implements NewsApplication_HiltComponents.FragmentC.Builder {
        private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

        private final ActivityRetainedCImpl activityRetainedCImpl;

        private final ActivityCImpl activityCImpl;

        private Fragment fragment;

        private FragmentCBuilder(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
            ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
          this.singletonC = singletonC;
          this.activityRetainedCImpl = activityRetainedCImpl;
          this.activityCImpl = activityCImpl;
        }

        @Override
        public FragmentCBuilder fragment(Fragment fragment) {
          this.fragment = Preconditions.checkNotNull(fragment);
          return this;
        }

        @Override
        public NewsApplication_HiltComponents.FragmentC build() {
          Preconditions.checkBuilderRequirement(fragment, Fragment.class);
          return new FragmentCI(singletonC, activityRetainedCImpl, activityCImpl, fragment);
        }
      }

      private static final class FragmentCI extends NewsApplication_HiltComponents.FragmentC {
        private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

        private final ActivityRetainedCImpl activityRetainedCImpl;

        private final ActivityCImpl activityCImpl;

        private final FragmentCI fragmentCI = this;

        private FragmentCI(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
            ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
            Fragment fragment) {
          this.singletonC = singletonC;
          this.activityRetainedCImpl = activityRetainedCImpl;
          this.activityCImpl = activityCImpl;

        }

        @Override
        public void injectNewsDetailsFragment(NewsDetailsFragment newsDetailsFragment) {
        }

        @Override
        public void injectNewsFragment(NewsFragment newsFragment) {
        }

        @Override
        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
          return activityCImpl.getHiltInternalFactoryFactory();
        }

        @Override
        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
          return new ViewWithFragmentCBuilder(singletonC, activityRetainedCImpl, activityCImpl, fragmentCI);
        }

        private static final class ViewWithFragmentCBuilder implements NewsApplication_HiltComponents.ViewWithFragmentC.Builder {
          private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

          private final ActivityRetainedCImpl activityRetainedCImpl;

          private final ActivityCImpl activityCImpl;

          private final FragmentCI fragmentCI;

          private View view;

          private ViewWithFragmentCBuilder(
              DaggerNewsApplication_HiltComponents_SingletonC singletonC,
              ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
              FragmentCI fragmentCI) {
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCI = fragmentCI;
          }

          @Override
          public ViewWithFragmentCBuilder view(View view) {
            this.view = Preconditions.checkNotNull(view);
            return this;
          }

          @Override
          public NewsApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(view, View.class);
            return new ViewWithFragmentCI(singletonC, activityRetainedCImpl, activityCImpl, fragmentCI, view);
          }
        }

        private static final class ViewWithFragmentCI extends NewsApplication_HiltComponents.ViewWithFragmentC {
          private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

          private final ActivityRetainedCImpl activityRetainedCImpl;

          private final ActivityCImpl activityCImpl;

          private final FragmentCI fragmentCI;

          private final ViewWithFragmentCI viewWithFragmentCI = this;

          private ViewWithFragmentCI(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
              ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
              FragmentCI fragmentCI, View view) {
            this.singletonC = singletonC;
            this.activityRetainedCImpl = activityRetainedCImpl;
            this.activityCImpl = activityCImpl;
            this.fragmentCI = fragmentCI;

          }
        }
      }

      private static final class ViewCBuilder implements NewsApplication_HiltComponents.ViewC.Builder {
        private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

        private final ActivityRetainedCImpl activityRetainedCImpl;

        private final ActivityCImpl activityCImpl;

        private View view;

        private ViewCBuilder(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
            ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
          this.singletonC = singletonC;
          this.activityRetainedCImpl = activityRetainedCImpl;
          this.activityCImpl = activityCImpl;
        }

        @Override
        public ViewCBuilder view(View view) {
          this.view = Preconditions.checkNotNull(view);
          return this;
        }

        @Override
        public NewsApplication_HiltComponents.ViewC build() {
          Preconditions.checkBuilderRequirement(view, View.class);
          return new ViewCI(singletonC, activityRetainedCImpl, activityCImpl, view);
        }
      }

      private static final class ViewCI extends NewsApplication_HiltComponents.ViewC {
        private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

        private final ActivityRetainedCImpl activityRetainedCImpl;

        private final ActivityCImpl activityCImpl;

        private final ViewCI viewCI = this;

        private ViewCI(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
            ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl, View view) {
          this.singletonC = singletonC;
          this.activityRetainedCImpl = activityRetainedCImpl;
          this.activityCImpl = activityCImpl;

        }
      }
    }

    private static final class ViewModelCBuilder implements NewsApplication_HiltComponents.ViewModelC.Builder {
      private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private SavedStateHandle savedStateHandle;

      private ViewModelCBuilder(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
          ActivityRetainedCImpl activityRetainedCImpl) {
        this.singletonC = singletonC;
        this.activityRetainedCImpl = activityRetainedCImpl;
      }

      @Override
      public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
        this.savedStateHandle = Preconditions.checkNotNull(handle);
        return this;
      }

      @Override
      public NewsApplication_HiltComponents.ViewModelC build() {
        Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
        return new ViewModelCImpl(singletonC, activityRetainedCImpl, savedStateHandle);
      }
    }

    private static final class ViewModelCImpl extends NewsApplication_HiltComponents.ViewModelC {
      private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl = this;

      private volatile Provider<NewsViewModel> newsViewModelProvider;

      private ViewModelCImpl(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
          ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandle) {
        this.singletonC = singletonC;
        this.activityRetainedCImpl = activityRetainedCImpl;

      }

      private NewsViewModel newsViewModel() {
        return new NewsViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonC.applicationContextModule), singletonC.newsRepository());
      }

      private Provider<NewsViewModel> newsViewModelProvider() {
        Object local = newsViewModelProvider;
        if (local == null) {
          local = new SwitchingProvider<>(singletonC, activityRetainedCImpl, viewModelCImpl, 0);
          newsViewModelProvider = (Provider<NewsViewModel>) local;
        }
        return (Provider<NewsViewModel>) local;
      }

      @Override
      public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
        return Collections.<String, Provider<ViewModel>>singletonMap("com.abdull.newsapp.ui.NewsViewModel", (Provider) newsViewModelProvider());
      }

      private static final class SwitchingProvider<T> implements Provider<T> {
        private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

        private final ActivityRetainedCImpl activityRetainedCImpl;

        private final ViewModelCImpl viewModelCImpl;

        private final int id;

        SwitchingProvider(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
            ActivityRetainedCImpl activityRetainedCImpl, ViewModelCImpl viewModelCImpl, int id) {
          this.singletonC = singletonC;
          this.activityRetainedCImpl = activityRetainedCImpl;
          this.viewModelCImpl = viewModelCImpl;
          this.id = id;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T get() {
          switch (id) {
            case 0: // com.abdull.newsapp.ui.NewsViewModel 
            return (T) viewModelCImpl.newsViewModel();

            default: throw new AssertionError(id);
          }
        }
      }
    }
  }

  private static final class ServiceCBuilder implements NewsApplication_HiltComponents.ServiceC.Builder {
    private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

    private Service service;

    private ServiceCBuilder(DaggerNewsApplication_HiltComponents_SingletonC singletonC) {
      this.singletonC = singletonC;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public NewsApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonC, service);
    }
  }

  private static final class ServiceCImpl extends NewsApplication_HiltComponents.ServiceC {
    private final DaggerNewsApplication_HiltComponents_SingletonC singletonC;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(DaggerNewsApplication_HiltComponents_SingletonC singletonC,
        Service service) {
      this.singletonC = singletonC;

    }
  }
}
