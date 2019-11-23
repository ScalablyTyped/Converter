/// <reference types="react" />

declare namespace __MaterialUI {
    export class SvgIcon extends React.Component<{}> {
    }
    namespace Styles {
        let a: any;
        let zIndex: any;
        let Transitions: any;
        let Typography: any;
        function getMuiTheme(...muiTheme: MuiTheme[]): MuiTheme;
        interface MuiTheme {spacing?: any;}
    }

    namespace BottomNavigation {

        export interface BottomNavigationItemProps  {
            className?: string;
            children: number;
        }

        export class BottomNavigationItem extends React.Component<BottomNavigationItemProps> { }
    }

}

declare module 'material-ui/styles' {
    export import getMuiTheme = __MaterialUI.Styles.getMuiTheme;
    export import spacing = __MaterialUI.Styles.a;
    export import transitions = __MaterialUI.Styles.Transitions;
    export import typography = __MaterialUI.Styles.Typography;
    export import zIndex = __MaterialUI.Styles.zIndex;
}

declare module 'material-ui/svg-icons/action/accessibility' {
    export import ActionAccessibility = __MaterialUI.SvgIcon;
    export default ActionAccessibility;
}

declare module 'material-ui/BottomNavigation/BottomNavigationItem' {
    export import BottomNavigationItem = __MaterialUI.BottomNavigation.BottomNavigationItem;
    export default BottomNavigationItem;
}
