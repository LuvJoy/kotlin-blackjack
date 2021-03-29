package blackjack.domain.state

import blackjack.domain.card.Card
import blackjack.domain.card.Cards
import blackjack.domain.card.Score

class Hit(val cards: Cards) : State {
    constructor(vararg cards: Card) : this(Cards(cards.toList() as ArrayList<Card>))
    override val isFinished: Boolean
        get() = cards.isBlackjack

    override fun draw(card: Card): State {
        cards.add(card)
        if (cards.isBust) {
            return Bust()
        }
        return Hit(cards)
    }

    fun stay(): State {
        return Stay()
    }

    override fun profit(money: Double): Double {
        throw UnsupportedOperationException("아직 게임이 끝나지 않았습니다.")
    }
}
