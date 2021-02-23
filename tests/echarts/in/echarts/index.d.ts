declare namespace echarts {
  namespace EChartOption {
    type DataZoom = DataZoom.Inside | DataZoom.Slider;

    namespace DataZoom {
      interface Inside {
        type?: string;
        id?: string;
        disabled?: boolean;
      }
      interface Slider {
        type?: string;
        id?: string;
      }
    }
  }
}
