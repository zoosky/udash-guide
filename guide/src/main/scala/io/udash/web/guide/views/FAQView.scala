package io.udash.web.guide.views

import io.udash._
import io.udash.web.guide.RootState
import io.udash.web.guide.styles.partials.GuideStyles
import org.scalajs.dom.Element

object FAQViewPresenter extends DefaultViewPresenterFactory[RootState.type](() => new FAQView)

class FAQView extends FinalView {
  import scalacss.ScalatagsCss._
  import scalatags.JsDom.all._

  private val content = div(
    h2("FAQ"),
    p("TODO")
  )

  override def getTemplate: Modifier = content
}