package io.udash.guide.views.ext.demo

import io.udash.guide.demos.i18n.Translations
import io.udash.guide.styles.BootstrapStyles
import io.udash.guide.styles.partials.GuideStyles
import io.udash.i18n._
import org.scalajs.dom
import org.scalajs.dom.Event
import org.scalajs.dom.ext.LocalStorage

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object DynamicRemoteTranslationsDemo {
  import scalacss.ScalatagsCss._
  import scalatags.JsDom.all._

  def apply(): dom.Element = {
    import io.udash.guide.Context._
    implicit val translationProvider = new RemoteTranslationProvider(serverRpc.demos().translations(), Some(LocalStorage), 6 hours)
    implicit val lang = LangProperty(Lang("en"))
    div(id := "dynamic-rpc-translations-demo", GuideStyles.frame)(
      button(BootstrapStyles.btn, BootstrapStyles.btnPrimary)(onclick := ((_: Event) => lang.set(Lang("en"))))("EN"), " ",
      button(BootstrapStyles.btn, BootstrapStyles.btnPrimary)(onclick := ((_: Event) => lang.set(Lang("pl"))))("PL"),
      ul(
        li("auth.loginLabel: ", translatedDynamic(Translations.auth.loginLabel)(_.apply())),
        li("auth.passwordLabel: ", translatedDynamic(Translations.auth.passwordLabel)(_.apply())),
        li("auth.login.buttonLabel: ", translatedDynamic(Translations.auth.login.buttonLabel)(_.apply())),
        li("auth.login.retriesLeft: ", translatedDynamic(Translations.auth.login.retriesLeft)(_.apply(3))),
        li("auth.login.retriesLeftOne: ", translatedDynamic(Translations.auth.login.retriesLeftOne)(_.apply())),
        li("auth.register.buttonLabel: ", translatedDynamic(Translations.auth.register.buttonLabel)(_.apply()))
      )
    ).render
  }
}