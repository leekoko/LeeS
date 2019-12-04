import RouterDemo from './components/RouterDemo'
import LifeGame from './pages/lifegame/LifeGame'
import Diary from './pages/lifegame/Diary'
import Plan from './pages/lifegame/Plan'
import EditPlan from './pages/lifegame/EditPlan'

const routes = [
  {
    path: '/lifegame',
    component: LifeGame,
  },
  {
    path: '/lifegame/diary',
    component: Diary,
  },
  {
    path: '/lifegame/plan',
    component: Plan,
  },
  {
    path: '/lifegame/editPlan',
    component: EditPlan,
  },

  { path: '*', component: RouterDemo, name: '404' }
]

export default routes